package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidClearBudgetException;
import seedu.duke.exceptions.InvalidClearRepaymentException;
import seedu.duke.exceptions.InvalidClearSpendingException;
import seedu.duke.exceptions.InvalidIndexException;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurgeDataCommand extends Command {
    private static Logger logger = Logger.getLogger("PurgeDataCommand");

    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException,
            InvalidIndexException, InvalidClearRepaymentException, InvalidClearBudgetException,
            InvalidClearSpendingException {
        logger.log(Level.FINE, "going to purge data");
        ClearSpendingListCommand clearSpendingListCommand = new ClearSpendingListCommand(true, 0);
        ClearRepaymentListCommand clearRepaymentListCommand = new ClearRepaymentListCommand(true, 0);
        ClearBudgetCommand clearBudgetCommand = new ClearBudgetCommand();
        clearSpendingListCommand.execute(spendingList, repaymentList, ui);
        clearRepaymentListCommand.execute(spendingList, repaymentList, ui);
        clearBudgetCommand.execute(null, null, ui);
        ui.printPurgeData();
    }
}
