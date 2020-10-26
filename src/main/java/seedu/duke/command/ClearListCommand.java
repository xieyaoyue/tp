package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

public class ClearListCommand extends Command {
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException {
        spendingList.clearAllItems();
        repaymentList.clearAllEntries();
        assert spendingList.getListSize() == 0 : "List size should be 0";
        assert repaymentList.getListSize() == 0 : "List size should be 0";
        ui.printClearAll();
    }
}
