package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class HelpCommand extends Command {

    @Override
    public void execute(SpendingList spendingList, Ui ui) {
        ui.printHelp();
    }
}
