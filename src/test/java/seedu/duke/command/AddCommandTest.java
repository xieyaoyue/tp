package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.*;
import seedu.duke.ui.Ui;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCommandTest {

    @Test
    void execute() throws IOException, InvalidInputCurrencyException, InvalidAmountException, InvalidNameException {
        AddCommand addCommand = new AddCommand("sushi", "SGD", 3.0, null);
        SpendingList spendingList = new SpendingList();
        Ui ui = new Ui();
        addCommand.execute(spendingList, null, ui);
        assertEquals("sushi", spendingList.getItem(0).getDescription());
        assertEquals("SGD", spendingList.getItem(0).getSymbol());
        assertEquals(3.0, spendingList.getItem(0).getAmount());
    }
}