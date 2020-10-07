package seedu.duke.Command;

import seedu.duke.Command.Command;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class HelpCommand extends Command {

    public void execute(SpendingList spendingList, Ui ui) {
        ui.printHelp();
    }
}
