package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.SpendingList;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.exceptions.InvalidStorageFileExtensionException;
import seedu.duke.exceptions.InvalidStorageFilePathException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCommandTest {

    @Test
    void execute() throws IOException, InvalidStorageFileExtensionException, InvalidStorageFilePathException {
        AddCommand addCommand = new AddCommand("buy sushi", "$", 3.0);
        Storage storage = new Storage();
        SpendingList spendingList = new SpendingList(storage);
        Ui ui = new Ui();
        addCommand.execute(spendingList, ui);
        assertEquals(spendingList.getItem(0).getDescription(), "buy sushi");
        assertEquals(spendingList.getItem(0).getSymbol(), "$");
        assertEquals(spendingList.getItem(0).getAmount(), 3.0);
    }
}