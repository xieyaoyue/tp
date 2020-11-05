package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.*;
import seedu.duke.ui.Ui;

import java.io.IOException;


public abstract class Command {
    public abstract void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException,
            InvalidMonthException, InvalidIndexException, InvalidClearRepaymentException, InvalidClearSpendingException,
            InvalidClearBudgetException, InvalidAmountException, InvalidInputCurrencyException,
            InvalidOutputCurrencyException, InvalidCurrencyException, EmptyListException, InvalidDateException,
            InvalidNameException, InvalidBudgetException, InvalidNumberException;

    public boolean isExit() {
        return false;
    }
}
