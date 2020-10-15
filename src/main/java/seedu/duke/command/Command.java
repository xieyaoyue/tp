package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidMonthException;

import java.io.IOException;

public abstract class Command {
    public abstract void execute(SpendingList spendingList, Ui ui) throws InvalidCommandException, IOException,
            InvalidMonthException;

    public boolean isExit() {
        return false;
    }
}
