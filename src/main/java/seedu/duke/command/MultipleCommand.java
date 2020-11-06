package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.*;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class MultipleCommand extends Command {
    public ArrayList<Command> commands = new ArrayList<>();

    public void addCommand(Command c) {
        commands.add(c);
    }

    public boolean noCommandsGiven() {
        return commands.isEmpty();
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException,
            InvalidMonthException, InvalidIndexException, InvalidClearRepaymentException, InvalidClearSpendingException,
            InvalidClearBudgetException, InvalidAmountException, InvalidInputCurrencyException,
            InvalidOutputCurrencyException, InvalidCurrencyException, EmptyListException, InvalidDateException,
            InvalidNameException, InvalidBudgetException, InvalidNumberException, EmptyCommandException,
            InvalidYearException {
        for (Command c : commands) {
            c.execute(spendingList, repaymentList, ui);
        }
    }
}
