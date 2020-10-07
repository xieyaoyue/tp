package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class ExitCommand extends Command {

    public void execute(SpendingList spendingList, Ui ui) {
        ui.printGoodbyeMessage();
    }
    
    public boolean isExit() {
        return true;
    }
}
