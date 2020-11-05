package seedu.duke.command;

import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidClearBudgetException;
import seedu.duke.ui.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClearBudgetCommand extends Command {
    private static Logger logger = Logger.getLogger("ClearBudgetCommand");

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws InvalidClearBudgetException {
        if(!Budget.hasBudget) {
            throw new InvalidClearBudgetException();
        }
        logger.log(Level.FINE, "going to clear budget");
        Budget.clearBudget();
        ui.printClearBudget();
    }
}
