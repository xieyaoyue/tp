package seedu.duke.command;

import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.ui.Ui;

//@@author killingbear999
public class SetBudgetCommand extends Command {

    private double budgetLimit;
    private String currency;

    
    public SetBudgetCommand(String currency, Double budgetLimit) {
        this.currency = currency;
        this.budgetLimit = budgetLimit;
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) {
        Budget.addBudget(currency, budgetLimit);
        ui.printBudgetLimit(currency, budgetLimit);
    }
}
