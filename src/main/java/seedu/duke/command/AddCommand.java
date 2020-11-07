package seedu.duke.command;

import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidAmountException;
import seedu.duke.exceptions.InvalidInputCurrencyException;
import seedu.duke.exceptions.InvalidNameException;
import seedu.duke.utilities.AmountConverter;
import seedu.duke.utilities.DecimalFormatter;
import seedu.duke.utilities.SpendingListCategoriser;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCommand extends Command {
    public String description;
    public double amount;
    public String currency;
    public String category;
    private String defaultCurrency = "SGD";
    private static Logger logger = Logger.getLogger("AddCommand");

    public AddCommand(String description, String symbol, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.currency = symbol;
        this.category = category;
    }
    
    //@@author killingbear999
    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException,
            InvalidInputCurrencyException, InvalidAmountException, InvalidNameException {
        logger.log(Level.FINE, "going to add item");
        int size = spendingList.getListSize();
        if (size != 0) {
            defaultCurrency = spendingList.getItem(0).getSymbol();
        }
        if (!currency.equals(defaultCurrency)) {
            AmountConverter amountConverter = new AmountConverter(currency, amount, defaultCurrency);
            amount = amountConverter.updateAmount();
            currency = amountConverter.updateCurrency();
        }
        if (!isValidName()) {
            throw new InvalidNameException();
        }
        if (amount < 0.01) {
            throw new InvalidAmountException();
        }
        if (!(currency.equals("SGD") || currency.equals("USD") || currency.equals("CNY"))) {
            throw new InvalidInputCurrencyException();
        }
        
        DecimalFormatter decimalFormatter = new DecimalFormatter();
        amount = decimalFormatter.convert(amount);
        spendingList.addItem(description, currency, amount, category);
        ui.printAdd(spendingList);

        
        if (size > 1) {
            SpendingListCategoriser spendingListCategoriser = new SpendingListCategoriser();
            spendingListCategoriser.execute(spendingList);
        }
        
        if (size > 0 && size % 4 == 0) {
            EncouragementCommand encouragementCommand = new EncouragementCommand();
            encouragementCommand.execute(spendingList, null, ui);
        }
        
        if (Budget.hasBudget) {
            WarnCommand warnCommand = new WarnCommand();
            warnCommand.execute(spendingList, null, ui);
        }
    }
    
    //@@author killingbear999
    private boolean isValidName() {
        return description.matches(".*[a-zA-Z]+.*");
    }
}
