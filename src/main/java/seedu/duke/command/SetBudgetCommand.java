package seedu.duke.command;

import seedu.duke.Budget;
import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

//@@author killingbear999
public class SetBudgetCommand extends Command {
    
    private String description;

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
