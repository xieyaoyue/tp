package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.Ui;

//@@author killingbear999
public class RepaymentListCommand extends Command {
    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) {
        ui.printRepaymentList(repaymentList.getRepaymentList());
    }
}
