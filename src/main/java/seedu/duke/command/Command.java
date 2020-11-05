package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidClearRepaymentException;
import seedu.duke.exceptions.InvalidClearSpendingException;
import seedu.duke.exceptions.InvalidMonthException;
import seedu.duke.exceptions.InvalidIndexException;
import seedu.duke.exceptions.InvalidClearBudgetException;
import seedu.duke.ui.Ui;

import java.io.IOException;


public abstract class Command {
    public abstract void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException,
            InvalidMonthException, InvalidIndexException, InvalidClearRepaymentException, InvalidClearSpendingException,
            InvalidClearBudgetException;

    public boolean isExit() {
        return false;
    }
}
