package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.SpendingList;
import seedu.duke.Ui;
import seedu.duke.category.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//@@author killingbear999
public class ConvertCommandTest {
    public static ArrayList<Item> initList(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
    
    public static SpendingList initSpendingList(Item... items) {
        return new SpendingList(initList(items));
    }
    
    SpendingList realList = initSpendingList(
            new Item("sushi", "SGD", 10.5),
            new Item("bubble tea", "SGD", 4.0),
            new Item("medicine", "SGD", 5.0)
    );
    
    @Test
    public void execute() throws IOException {
        Ui ui = new Ui();
        ConvertCommand convertCommand = new ConvertCommand();
        convertCommand.execute(realList, null, ui);
    }
}
