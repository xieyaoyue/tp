package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.category.Item;

import java.util.ArrayList;
import java.util.Arrays;

class ExportCommandTest {
    public static ArrayList<Item> initList(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

    public static SpendingList initSpendingList(Item... items) {
        return new SpendingList(initList(items));
    }

    SpendingList spendingList = initSpendingList(
            new Item("Item0", "SGD", 1.5),
            new Item("Item1", "RMB", 233, "Food"),
            new Item("Item2", "USD", 13.14, "Book")
    );

    Ui ui = new Ui();

    @Test
    void execute() {
        try {
            new ExportCommand(System.getProperty("F:\\")).execute(spendingList, ui);
        } catch (Exception e) {
            assert false;
        }
        assert true;
    }
}