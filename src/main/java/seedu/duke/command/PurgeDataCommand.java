package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

public class PurgeDataCommand extends Command {

    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        RepaymentList repaymentList = new RepaymentList();
        ClearSpendingListCommand clearSpendingListCommand = new ClearSpendingListCommand(true, 0);
        ClearRepaymentListCommand clearRepaymentListCommand = new ClearRepaymentListCommand(true, 0);
        ClearBudgetCommand clearBudgetCommand = new ClearBudgetCommand();
        clearSpendingListCommand.execute(spendingList, ui);
        clearRepaymentListCommand.execute(repaymentList, ui);
        clearBudgetCommand.execute(spendingList, ui);
        ui.printPurgeData();
    }
}
