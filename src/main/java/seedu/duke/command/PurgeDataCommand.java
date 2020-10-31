package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

public class PurgeDataCommand extends Command {

    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException {
        ClearSpendingListCommand clearSpendingListCommand = new ClearSpendingListCommand(true, 0);
        ClearRepaymentListCommand clearRepaymentListCommand = new ClearRepaymentListCommand(true, 0);
        ClearBudgetCommand clearBudgetCommand = new ClearBudgetCommand();
        clearSpendingListCommand.execute(spendingList, repaymentList, ui);
        clearRepaymentListCommand.execute(spendingList, repaymentList, ui);
        clearBudgetCommand.execute(null, null, ui);
        ui.printPurgeData();
    }
}
