package seedu.duke.Command;

import seedu.duke.Command.Command;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class ExitCommand extends Command {

    public void execute(SpendingList spendingList, Ui ui) {
        ui.printGoodbyeMessage();
    }
    
//    public boolean isExit() {
//        if (description.startsWith("logout")) {
//            return true;
//        }
//        return false;
//    }
}
