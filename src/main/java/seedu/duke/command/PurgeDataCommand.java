package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

public class PurgeDataCommand extends Command {

    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        RepaymentList repaymentList = new RepaymentList();
        ClearListCommand clearListCommand = new ClearListCommand();
        ClearBudgetCommand clearBudgetCommand = new ClearBudgetCommand();
        clearListCommand.execute(spendingList, repaymentList, ui);
        clearBudgetCommand.execute(spendingList, ui);
        ui.printPurgeData();
    }
}
