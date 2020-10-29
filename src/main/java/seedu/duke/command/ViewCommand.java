package seedu.duke.command;

import seedu.duke.Budget;
import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

//@@author killingbear999
public class ViewCommand extends Command {

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) {
        if (Budget.hasBudget) {
            Ui.printCurrentBudgetLimit();
        } else {
            Ui.printNoBudget();
        }
    }
}
