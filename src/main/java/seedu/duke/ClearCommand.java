package seedu.duke;

public class ClearCommand {

    private boolean isClearAll;
    private int clearIndex;

    public ClearCommand(boolean isClearAll, int clearIndex) {
        this.isClearAll = isClearAll;
        if(!isClearAll) {
            this.clearIndex = clearIndex;
        }
    }
    
    public void execute(SpendingList spendingList, Ui ui) {
        if(!isClearAll) {
            ui.printClearIndex(spendingList.getItem(clearIndex - 1));
            spendingList.deleteItem(clearIndex - 1);
        } else {
            spendingList.clearAllItems();
            ui.printClearAll();
        }
    }
}
