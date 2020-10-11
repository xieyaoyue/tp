package seedu.duke.command;

import seedu.duke.Item;
import seedu.duke.SpendingList;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.exceptions.InvalidCommandException;

import java.util.ArrayList;

public class ListCommand extends Command {
    @Override
    public void execute(SpendingList spendingList, Ui ui) throws InvalidCommandException {
        ArrayList<Item> list = spendingList.getSpendingList();
        ui.printSpendingList(spendingList);
    }
}
