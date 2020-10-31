package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

public class ClearRepaymentListCommand extends Command {
    public boolean isClearAll;
    public Integer clearIndex;

    public ClearRepaymentListCommand(boolean isClearAll, Integer clearIndex) {
        this.isClearAll = isClearAll;
        this.clearIndex = clearIndex;
    }

    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException {
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
}
