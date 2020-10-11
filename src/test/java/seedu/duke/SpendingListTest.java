package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.InvalidStorageFileExtensionException;
import seedu.duke.exceptions.InvalidStorageFilePathException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpendingListTest {

    private Storage storage;
    private SpendingList spendingList;

    SpendingListTest() throws InvalidStorageFileExtensionException, InvalidStorageFilePathException {
        storage = new Storage();
        spendingList = storage.load();
    }

    @Test
    void getItem() throws IOException {
        spendingList.addItem("buy book", "S$", 10);
        assertEquals(spendingList.getItem(0).description, "buy book");
        assertEquals(spendingList.getItem(0).symbol, "S$");
        assertEquals(spendingList.getItem(0).amount, 10);
    }

    @Test
    void getListSize() throws IOException {
        spendingList.addItem("buy book", "S$", 10);
        assertEquals(spendingList.getListSize(), 1);
        spendingList.addItem("buy stationary", "S$", 5);
        assertEquals(spendingList.getListSize(), 2);
        spendingList.deleteItem(0);
        assertEquals(spendingList.getListSize(), 1);
        spendingList.addItem("buy grocery", "S$", 10);
        assertEquals(spendingList.getListSize(), 2);
    }

    @Test
    void clearAllItems() throws IOException {
        spendingList.addItem("buy book", "S$", 10);
        spendingList.addItem("buy stationary", "S$", 5);
        spendingList.clearAllItems();
        assertEquals(spendingList.getListSize(), 0);
    }

    @Test
    void editItem() throws IOException {
        spendingList.addItem("buy book", "S$", 10);
        spendingList.editItem(0, "buy book", "S$", 12);
        assertEquals(spendingList.getItem(0).amount, 12);
    }
}