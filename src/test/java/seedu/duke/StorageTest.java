package seedu.duke;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidStorageFileExtensionException;
import seedu.duke.exceptions.InvalidStorageFilePathException;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StorageTest {
    private static Storage storage;

    @Test
    public void createFileAndPath() {
        String path = storage.getFilePath();
        File f = new File(path);
        assertTrue(f.exists(), "Did not create path or file");
    }

    // @Test
    public void saveAndLoad() throws IOException {
        SpendingList expectedList = new SpendingList(storage);
        expectedList.addItem("noodle", "S$", 1.5, "");
        expectedList.addItem("fish", "S$", 10, "");
        expectedList.addItem("books", "S$", 8.9, "");

        SpendingList actualList = storage.loadSpendingList();
        SpendingListTest.assertEqualList(expectedList, actualList);
    }

    @BeforeEach
    public void initStorage() throws InvalidStorageFilePathException, InvalidStorageFileExtensionException {
        String randomPath = String.format("data/%s.json", UUID.randomUUID().toString());
        storage = new Storage(randomPath);
    }

    @AfterEach
    public void deleteStorage() {
        String path = storage.getFilePath();
        storage = null;
        File f = new File(path);
        assertTrue(f.delete(), "Unable to delete file");
        assertFalse(f.exists(), "Did not delete file");
    }
}


