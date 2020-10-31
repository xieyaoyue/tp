package seedu.duke.command;

import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.utilities.SpendingListCategoriser;
import seedu.duke.Ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCommand extends Command {
    public String description;
    public double amount;
    public String currency;
    public String category;
    private static Logger logger = Logger.getLogger("AddCommand");

    public AddCommand(String description, String symbol, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.currency = symbol;
        this.category = category;
    }

    
    private final String[][] exchangeRates = {
            {"SGDUSD", "USDSGD", "SGDCNY", "CNYSGD"},
            {"0.74", "1.36", "4.99", "0.20"},
    };
    
    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException {
        logger.log(Level.FINE, "going to add item");
        if (!currency.equals("SGD")) {
            updateAmount();
            updateCurrency();
        }
        spendingList.addItem(description, currency, amount, category);
        ui.printAdd(spendingList);
        int size = spendingList.getListSize();
        if (size > 1) {
            SpendingListCategoriser spendingListCategoriser = new SpendingListCategoriser();
            spendingListCategoriser.execute(spendingList);
        }
        if (size % 8 == 0) {
            EncouragementCommand encouragementCommand = new EncouragementCommand();
            encouragementCommand.execute(spendingList, null, ui);
        }
        if (Budget.hasBudget) {
            WarnCommand warnCommand = new WarnCommand();
            warnCommand.execute(spendingList, null, ui);
        }
    }
    
    //@@author killingbear999
    private void updateAmount() {
        if (currency.equals("USD")) {
            amount = amount * Double.parseDouble(exchangeRates[1][1]);
        } else if (currency.equals("CNY")) {
            amount = amount * Double.parseDouble(exchangeRates[1][3]);
        }
    }
    
    private void updateCurrency() {
        currency = "SGD";
    }
}
