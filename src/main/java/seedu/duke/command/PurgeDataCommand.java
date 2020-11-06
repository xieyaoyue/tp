package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidClearBudgetException;
import seedu.duke.exceptions.InvalidClearRepaymentException;
import seedu.duke.exceptions.InvalidClearSpendingException;
import seedu.duke.exceptions.InvalidNumberException;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurgeDataCommand extends Command {
    private static Logger logger = Logger.getLogger("PurgeDataCommand");

    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException {
        logger.log(Level.FINE, "going to purge data");
        ClearSpendingListCommand clearSpendingListCommand = new ClearSpendingListCommand(true, 0);
        ClearRepaymentListCommand clearRepaymentListCommand = new ClearRepaymentListCommand(true, 0);
        ClearBudgetCommand clearBudgetCommand = new ClearBudgetCommand();
        try {
            clearSpendingListCommand.execute(spendingList, repaymentList, ui);
        } catch (InvalidClearSpendingException | InvalidNumberException ignore) {
            //this is expected
        }
        try {
            clearRepaymentListCommand.execute(spendingList, repaymentList, ui);
        } catch (InvalidClearRepaymentException | InvalidNumberException ignore) {
            //this is expected
        }
        try {
            clearBudgetCommand.execute(null, null, ui);
        } catch (InvalidClearBudgetException ignore) {
            //this is expected
        }
        ui.printPurgeData();
    }
}
