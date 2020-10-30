package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class EncouragementCommand extends Command {

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) {
        ui.printEncouragementMessage();
    }
}
