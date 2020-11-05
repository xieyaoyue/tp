package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidAmountException;
import seedu.duke.exceptions.InvalidNumberException;
import seedu.duke.exceptions.InvalidNameException;
import seedu.duke.exceptions.InvalidInputCurrencyException;
import seedu.duke.ui.Ui;
import seedu.duke.utilities.DecimalFormatter;

import java.io.IOException;

//@@author killingbear999
public class EditCommand extends Command {
    public String description;
    public Double amount;
    public String currency;
    public int index;
    public String category;

    public EditCommand(int index, String description, String currency, Double amount, String category) {
        this.index = index - 1;
        this.description = description;
        this.currency = currency;
        this.amount = amount;
        this.category = category;
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException,
            InvalidAmountException, InvalidNumberException, InvalidInputCurrencyException, InvalidNameException {
       
        if (index >= spendingList.getListSize()) {
            throw new InvalidNumberException();
        }
        
        if (description != null) {
            if (!isValidName()) {
                throw new InvalidNameException();
            }
            spendingList.editItemDescription(index, description);
            ui.printEdit(spendingList, index);
        }
        
        if (amount != null) {
            if (!(currency.equals("SGD") || currency.equals("USD") || currency.equals("CNY"))) {
                throw new InvalidInputCurrencyException();
            }
            if (amount < 0.01) {
                throw new InvalidAmountException();
            }
            String defaultCurrency = spendingList.getItem(0).getSymbol();
            if (currency.equals(defaultCurrency)) {
                DecimalFormatter decimalFormatter = new DecimalFormatter();
                amount = decimalFormatter.convert(amount);
                spendingList.editItemAmount(index, amount);
                ui.printEdit(spendingList, index);
            } else {
                ui.printInvalidConversion(defaultCurrency);
            }
        }
        
        if (category != null) {
            spendingList.editItemCategory(index, category);
            ui.printEdit(spendingList, index);
        }
    }
    
    private boolean isValidName() {
        return description.matches(".*[a-zA-Z]+.*");
    }
}
