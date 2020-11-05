package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidClearSpendingException;
import seedu.duke.exceptions.InvalidIndexException;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClearSpendingListCommand extends Command {
    private boolean isClearAll;
    private int clearIndex;
    private static Logger logger = Logger.getLogger("ClearSpendingListCommand");

    public ClearSpendingListCommand(boolean isClearAll, int clearIndex) {
        this.isClearAll = isClearAll;
        this.clearIndex = clearIndex;
    }

    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException,
            InvalidIndexException, InvalidClearSpendingException {
        int size = spendingList.getListSize();
        if (size == 0) {
            throw new InvalidClearSpendingException();
        }
        if (clearIndex > size) {
            logger.log(Level.FINE, "clearIndex is invalid");
            throw new InvalidIndexException();
        }
        logger.log(Level.FINE, "going to clear spending list");
        if (!isClearAll) {
            int beforeClearSize = spendingList.getListSize();
            ui.printClearIndex(spendingList.getItem(clearIndex - 1));
            spendingList.deleteItem(clearIndex - 1);
            int afterClearSize = spendingList.getListSize();
            assert beforeClearSize - afterClearSize == 1 : "One item should be cleared from spending list";
        } else {
            spendingList.clearAllItems();
            assert spendingList.getListSize() == 0 : "List size should be 0";
            ui.printClearAllSpendingList();
        }
    }
}
