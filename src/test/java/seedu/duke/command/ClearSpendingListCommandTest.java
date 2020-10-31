package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.SpendingList;
import seedu.duke.ui.Ui;
import seedu.duke.exceptions.InvalidStorageFileExtensionException;
import seedu.duke.exceptions.InvalidStorageFilePathException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClearSpendingListCommandTest {

    @Test
    void execute_clearIndex() throws InvalidStorageFileExtensionException,
            InvalidStorageFilePathException, IOException {
        ClearSpendingListCommand c = new ClearSpendingListCommand(false, 1);
        SpendingList spendingList = new SpendingList();
        Ui ui = new Ui();
        spendingList.addItem("buy chicken rice", "$", 3.0);
        spendingList.addItem("buy sushi", "$", 5.1);
        c.execute(spendingList, null, ui);
        assertEquals(1, spendingList.getListSize());
    }

    @Test
    void execute_clearAll() throws InvalidStorageFileExtensionException, InvalidStorageFilePathException, IOException {
        ClearSpendingListCommand c = new ClearSpendingListCommand(true, 0);
        SpendingList spendingList = new SpendingList();
        Ui ui = new Ui();
        spendingList.addItem("buy chicken rice", "$", 3.0);
        spendingList.addItem("buy sushi", "$", 5.1);
        c.execute(spendingList, null, ui);
        assertEquals(0, spendingList.getListSize());
    }

}