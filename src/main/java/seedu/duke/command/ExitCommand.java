package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class ExitCommand extends Command {

    public ExitCommand() {
    }

    @Override
    public void execute(SpendingList spendingList, Ui ui) {
    }

    public boolean isExit() {
        return true;
    }
}
