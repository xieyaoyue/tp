package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class SpendingListCommand extends Command {
    @Override
    public void execute(SpendingList spendingList, Ui ui) {
        ui.printSpendingList(spendingList);
    }
}
