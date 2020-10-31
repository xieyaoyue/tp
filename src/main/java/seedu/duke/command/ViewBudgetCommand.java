package seedu.duke.command;

import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.ui.Ui;

//@@author killingbear999
public class ViewBudgetCommand extends Command {

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) {
        if (Budget.hasBudget) {
            Ui.printCurrentBudgetLimit();
        } else {
            Ui.printNoBudget();
        }
    }
}
