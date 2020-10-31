package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.SpendingList;
import seedu.duke.Ui;
import seedu.duke.exceptions.InvalidStorageFileExtensionException;
import seedu.duke.exceptions.InvalidStorageFilePathException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCommandTest {

    @Test
    void execute() throws IOException, InvalidStorageFileExtensionException, InvalidStorageFilePathException {
        AddCommand addCommand = new AddCommand("buy sushi", "SGD", 3.0, null);
        SpendingList spendingList = new SpendingList();
        Ui ui = new Ui();
        addCommand.execute(spendingList, null, ui);
        assertEquals("buy sushi", spendingList.getItem(0).getDescription());
        assertEquals("SGD", spendingList.getItem(0).getSymbol());
        assertEquals(3.0, spendingList.getItem(0).getAmount());
    }
}