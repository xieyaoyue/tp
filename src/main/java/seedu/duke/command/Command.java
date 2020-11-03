package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.ui.Ui;
import seedu.duke.exceptions.InvalidMonthException;

import java.io.IOException;


public abstract class Command {
    public abstract void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException,
        InvalidMonthException;

    public boolean isExit() {
        return false;
    }
}
