package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidMonthException;

import java.io.IOException;

public class Command {
    public void execute(SpendingList spendingList, Ui ui) throws InvalidCommandException, IOException,
            InvalidMonthException {
    }

    public void execute(RepaymentList repaymentList, Ui ui) {
    }

    public boolean isExit() {
        return false;
    }
}
