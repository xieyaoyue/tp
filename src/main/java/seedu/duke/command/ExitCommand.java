package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class ExitCommand extends Command {

    private String description;

    public ExitCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(SpendingList spendingList, Ui ui) {

    }

    public boolean isExit() {
        if (description.startsWith("logout")) {
            return true;
        }
        return false;
    }
}
