package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.Budget;
import seedu.duke.data.SpendingList;
import seedu.duke.ui.Ui;
import seedu.duke.data.Item;

import java.util.ArrayList;
import java.util.Arrays;

//@@author killingbear999
public class WarnCommandTest {
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
    public void approachLimit() {
        Ui ui = new Ui();
        Budget.addBudget("SGD", 20.0);
        WarnCommand approachingLimit = new WarnCommand();
        approachingLimit.execute(realList, null, ui);
    }
    
    @Test
    public void exceedLimit() {
        Ui ui = new Ui();
        Budget.addBudget("SGD", 10.0);
        WarnCommand exceedingLimit = new WarnCommand();
        exceedingLimit.execute(realList, null, ui);
    }
}
