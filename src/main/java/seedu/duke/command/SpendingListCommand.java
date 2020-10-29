package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
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
