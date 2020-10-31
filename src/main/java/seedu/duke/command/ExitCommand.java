package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.Ui;

//@@author killingbear999
public class ExitCommand extends Command {

    public ExitCommand() {
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) {
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
