package seedu.duke.command;

import seedu.duke.category.Item;
import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.exceptions.InvalidCommandException;

import java.util.ArrayList;

public class SpendingListCommand extends Command {
    @Override
    public void execute(SpendingList spendingList, Ui ui) throws InvalidCommandException {
        ArrayList<Item> list = spendingList.getSpendingList();
        ui.printSpendingList(spendingList);
    }
}
