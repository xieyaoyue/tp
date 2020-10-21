package seedu.duke.command;

import seedu.duke.Budget;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

//@@author killingbear999
public class ViewCommand extends Command {
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) {
        if (Budget.hasBudget) {
            Ui.printBudgetLimit();
        } else {
            Ui.printNoBudget();
        }
    }
}
