package seedu.duke.command;

import org.junit.jupiter.api.Test;

import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.category.Item;
import seedu.duke.exceptions.InvalidMonthException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SummaryCommandTest {
    public static ArrayList<Item> initList(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

    public static SpendingList initSpendingList(Item... items) {
        return new SpendingList(initList(items));
    }

    SpendingList spendingList = initSpendingList(
            new Item("noodle", "S$", 1.5),
            new Item("fish", "S$", 10),
            new Item("books", "S$", 8.9)
    );

    @Test
    public void execute() {
        Ui ui = new Ui();
        SummaryCommand invalidSummaryMonth = new SummaryCommand("2020", "fdj");
        SummaryCommand validSummaryMonth = new SummaryCommand("2020", "Jan");
        SummaryCommand summaryYear = new SummaryCommand("2020");
        SummaryCommand summary = new SummaryCommand(true);
        try {
            invalidSummaryMonth.execute(spendingList, ui);
            validSummaryMonth.execute(spendingList, ui);
            summaryYear.execute(spendingList, ui);
            summary.execute(spendingList, ui);
        } catch (InvalidMonthException e) {
            assertEquals("Invalid month input.", e.toString());
        }

    }
}
