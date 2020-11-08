package seedu.duke.command;

import seedu.duke.data.Data;
import seedu.duke.data.Item;
import seedu.duke.exceptions.InvalidMonthException;
import seedu.duke.exceptions.InvalidYearException;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class SpendingListCommand extends DateCommand {
    protected String category = null;

    public SpendingListCommand() {
        // TODO : accept all time
        super();
    }

    public SpendingListCommand(String year, String month, String category) throws InvalidYearException,
        InvalidMonthException {
        super(year, month);
        this.category = category;
    }

    @Override
    public void execute(Data data, Ui ui) {
        ArrayList<Item> filteredList = data.spendingList.filterSpendingList(category, period);
        ui.printSpendingList(filteredList);
    }
}
