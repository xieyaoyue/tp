package seedu.duke.command;

import seedu.duke.Budget;
import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class ClearBudgetCommand extends Command {

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) {
        Budget.clearBudget();
    }
}
