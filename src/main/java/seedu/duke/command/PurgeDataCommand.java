package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

public class PurgeDataCommand extends Command {

    @Override
    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        ClearListCommand clearListCommand= new ClearListCommand(true, 0);
        ClearBudgetCommand clearBudgetCommand = new ClearBudgetCommand();
        clearListCommand.execute(spendingList, ui);
        clearBudgetCommand.execute(spendingList, ui);
        ui.printPurgeData();
    }
}
