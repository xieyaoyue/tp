package seedu.duke.command;

import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidBudgetException;
import seedu.duke.exceptions.InvalidInputCurrencyException;
import seedu.duke.ui.Ui;
import seedu.duke.utilities.AmountConverter;
import seedu.duke.utilities.DecimalFormatter;

//@@author killingbear999
public class SetBudgetCommand extends Command {

    private double budgetLimit;
    private String currency;
    private String defaultCurrency = "SGD";

    
    public SetBudgetCommand(String currency, Double budgetLimit) {
        this.currency = currency;
        this.budgetLimit = budgetLimit;
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui)
            throws InvalidInputCurrencyException, InvalidBudgetException {
        int size = spendingList.getListSize();
        if (size != 0) {
            defaultCurrency = spendingList.getItem(0).getSymbol();
        }
        if (!currency.equals(defaultCurrency)) {
            AmountConverter amountConverter = new AmountConverter(currency, budgetLimit, defaultCurrency);
            budgetLimit = amountConverter.updateAmount();
            currency = amountConverter.updateCurrency();
        }
        if (budgetLimit < 0.01) {
            throw new InvalidBudgetException();
        }
        if (!(currency.equals("SGD") || currency.equals("USD") || currency.equals("CNY"))) {
            throw new InvalidInputCurrencyException();
        }
        DecimalFormatter decimalFormatter = new DecimalFormatter();
        budgetLimit = decimalFormatter.convert(budgetLimit);
        Budget.addBudget(currency, budgetLimit);
        ui.printBudgetLimit(currency, budgetLimit);
    }
}
