package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

public class ClearSpendingListCommand extends Command {
    private boolean isClearAll;
    private int clearIndex;

    public ClearSpendingListCommand(boolean isClearAll, int clearIndex) {
        this.isClearAll = isClearAll;
        this.clearIndex = clearIndex;
    }

    public ClearSpendingListCommand() {
    }

    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        if (!isClearAll) {
            assert (clearIndex > 0 && clearIndex <= spendingList.getListSize()) : "Wrong index";
            ui.printClearIndex(spendingList.getItem(clearIndex - 1));
            spendingList.deleteItem(clearIndex - 1);
        } else {
            spendingList.clearAllItems();
            assert spendingList.getListSize() == 0 : "List size should be 0";
            ui.printClearAllSpendingList();
        }
    }

    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException {
        spendingList.clearAllItems();
        repaymentList.clearAllEntries();
        assert spendingList.getListSize() == 0 : "List size should be 0";
        assert repaymentList.getListSize() == 0 : "List size should be 0";
        ui.printClearAll();
    }
}
