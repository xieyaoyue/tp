package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.Ui;

public class ClearRepaymentListCommand extends Command {
    public boolean isClearAll;
    public Integer clearIndex;

    public ClearRepaymentListCommand(boolean isClearAll, Integer clearIndex) {
        this.isClearAll = isClearAll;
        this.clearIndex = clearIndex;
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
}
