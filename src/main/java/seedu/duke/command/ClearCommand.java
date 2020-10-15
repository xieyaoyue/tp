package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

public class ClearCommand extends Command {

    private boolean isClearAll;
    private int clearIndex;

    public ClearCommand(boolean isClearAll, int clearIndex) {
        this.isClearAll = isClearAll;
        if (!isClearAll) {
            this.clearIndex = clearIndex;
        }
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
            ui.printClearAll();
        }
    }
}
