package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.exceptions.InvalidCommandException;

public abstract class Command {
    public abstract void execute(SpendingList spendingList, Ui ui) throws InvalidCommandException;

    public boolean isExit() {
        return false;
    }
}
