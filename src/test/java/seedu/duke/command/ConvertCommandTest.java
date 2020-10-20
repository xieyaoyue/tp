package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.SpendingList;
import seedu.duke.category.Item;
import seedu.duke.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@@author killingbear999
public class ConvertCommandTest {
    public static ArrayList<Item> initList(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
    
    public static SpendingList initSpendingList(Item... items) {
        return new SpendingList(initList(items));
    }
    
    SpendingList realList = initSpendingList(
            new Item("sushi", "S$", 10.5),
            new Item("bubble tea", "S$", 4.0),
            new Item("medicine", "S$", 5.0)
    );
    
    @Test
    public void identifyCurrencySgdUsd() {
        String expectedCurrency = "SGD USD";
        String description = "-d SGD -d USD";
        ConvertCommand convertCommand = new ConvertCommand(description);
        assertEquals(expectedCurrency, convertCommand.identifyCurrency(description));
    }
    
    @Test
    public void execute() throws IOException {
        Ui ui = new Ui();
        String description = "-d SGD -d USD";
        ConvertCommand convertCommand = new ConvertCommand(description);
        convertCommand.execute(realList, ui);
    }
}
