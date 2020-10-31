package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.Ui;

public class SpendingListCommand extends DateCommand {
    public SpendingListCommand() {
        // TODO : accept all time
    }

    public SpendingListCommand(String year, String month) {
        // TODO : accept year and month (possibly null)
        // TODO : accept category
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) {
        ui.printSpendingList(spendingList);
    }
}
