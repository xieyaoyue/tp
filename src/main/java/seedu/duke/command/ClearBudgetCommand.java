package seedu.duke.command;

import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.ui.Ui;

public class ClearBudgetCommand extends Command {

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) {

        Budget.clearBudget();
        ui.printClearBudget();
    }
}
