package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

//@@author killingbear999
public class RepaymentListCommand extends Command {
    @Override
    public void execute(SpendingList spendingList, Ui ui) {
        RepaymentList repaymentList = new RepaymentList();
        ui.printRepaymentList(repaymentList.getRepaymentList());
    }
}