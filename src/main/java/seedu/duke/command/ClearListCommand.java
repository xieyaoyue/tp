package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

public class ClearListCommand extends Command {

    public boolean isClearAll;
    public int clearIndex;

    public ClearListCommand(boolean isClearAll, int clearIndex) {
        this.isClearAll = isClearAll;
        if (!isClearAll) {
            this.clearIndex = clearIndex;
        }
    }

    public ClearListCommand() {
    }

    @Override
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

    public void execute(RepaymentList repaymentList, Ui ui) {
        if (!isClearAll) {
            assert (clearIndex > 0 && clearIndex <= repaymentList.getListSize()) : "Wrong index";
            ui.printClearIndex(repaymentList.getEntry(clearIndex - 1));
            repaymentList.deleteRepaymentEntry(clearIndex - 1);
        } else {
            repaymentList.clearAllEntries();
            assert repaymentList.getListSize() == 0 : "List size should be 0";
            ui.printClearAllRepaymentList();
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
