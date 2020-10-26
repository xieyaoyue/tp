package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.Budget;
import seedu.duke.SpendingList;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.exceptions.InvalidStorageFileExtensionException;
import seedu.duke.exceptions.InvalidStorageFilePathException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PurgeDataCommandTest {

    @Test
    void execute() throws IOException, InvalidStorageFileExtensionException, InvalidStorageFilePathException {
        Storage storage = new Storage();
        SpendingList spendingList = new SpendingList(storage);
        spendingList.addItem("buy chicken rice", "$", 3.0);
        spendingList.addItem("buy sushi", "$", 5.1);
        Budget.addBudget("SGD", 100);
        PurgeDataCommand purgeDataCommand = new PurgeDataCommand();
        Ui ui = new Ui();
        purgeDataCommand.execute(spendingList, ui);
        assertFalse(Budget.hasBudget);
        assertEquals(0, spendingList.getListSize());
    }
}