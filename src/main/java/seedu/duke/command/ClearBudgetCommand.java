package seedu.duke.command;

import seedu.duke.Budget;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class ClearBudgetCommand extends Command {

    @Override
    public void execute(SpendingList spendingList, Ui ui) {
        Budget.clearBudget();
    }
}
