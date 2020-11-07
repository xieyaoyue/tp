package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.Data;
import seedu.duke.exceptions.InvalidClearSpendingException;
import seedu.duke.exceptions.InvalidNumberException;
import seedu.duke.exceptions.InvalidStorageFileExtensionException;
import seedu.duke.exceptions.InvalidStorageFilePathException;
import seedu.duke.ui.Ui;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClearSpendingListCommandTest {

    @Test
    void execute_clearIndex() throws InvalidStorageFileExtensionException,
            InvalidStorageFilePathException, IOException, InvalidClearSpendingException, InvalidNumberException {
        ClearSpendingListCommand c = new ClearSpendingListCommand(false, 1);
        Data data = new Data(null, null, null);
        Ui ui = new Ui();
        data.spendingList.addItem("buy chicken rice", "$", 3.0);
        data.spendingList.addItem("buy sushi", "$", 5.1);
        c.execute(data, ui);
        assertEquals(1, data.spendingList.getListSize());
    }

    @Test
    void execute_clearAll() throws InvalidStorageFileExtensionException, InvalidStorageFilePathException,
            IOException, InvalidClearSpendingException, InvalidNumberException {
        ClearSpendingListCommand c = new ClearSpendingListCommand(true, 0);
        Data data = new Data(null, null, null);
        Ui ui = new Ui();
        data.spendingList.addItem("buy chicken rice", "$", 3.0);
        data.spendingList.addItem("buy sushi", "$", 5.1);
        c.execute(data, ui);
        assertEquals(0, data.spendingList.getListSize());
    }

}