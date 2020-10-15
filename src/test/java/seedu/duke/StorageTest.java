package seedu.duke;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.InvalidStorageFileExtensionException;
import seedu.duke.exceptions.InvalidStorageFilePathException;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    private static Storage storage;

    @Test
    public void createFileAndPath() {
        String path = storage.getFilePath();
        File f = new File(path);
        assertTrue(f.exists(), "Did not create path or file");
    }

    @Test
    public void saveAndLoad() throws IOException {
        SpendingList expectedList = new SpendingList(storage);
        expectedList.addItem("noodle", "S$", 1.5);
        expectedList.addItem("fish", "S$", 10);
        expectedList.addItem("books", "S$", 8.9);

        SpendingList actualList = storage.load();
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


class StorageErrorTest {
    static class Rule<T extends Throwable> {
        final String path;
        final Class<T> exception;
        final String description;

        Rule(String path, Class<T> exception, String description) {
            this.path = path;
            this.exception = exception;
            this.description = description;
        }
    }

    static final Rule[] rules = {
            new Rule("   ", InvalidStorageFilePathException.class, "Allowed blank file path/names"),
            new Rule("json", InvalidStorageFileExtensionException.class, "Must specify file extension"),
            new Rule("data/test.txt", InvalidStorageFileExtensionException.class, "Allowed non JSON files"),
    };

    @Test
    public void fullFileName() {
        for (Rule r : rules) {
            assertThrows(r.exception, () -> {
                Storage s = new Storage(r.path);
            }, r.description);
        }
    }
}