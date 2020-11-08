package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidStorageFileExtensionException;
import seedu.duke.exceptions.InvalidStorageFilePathException;
import seedu.duke.exceptions.InvalidClearSpendingException;
import seedu.duke.exceptions.InvalidNumberException;
import seedu.duke.ui.Ui;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@@author xieyaoyue
class ClearSpendingListCommandTest {

    @Test
    void execute_clearIndex() throws IOException, InvalidClearSpendingException, InvalidNumberException {
        ClearSpendingListCommand c1 = new ClearSpendingListCommand(false, 3);
        SpendingList spendingList = new SpendingList();
        Ui ui = new Ui();
        spendingList.addItem("buy chicken rice", "$", 3.0);
        spendingList.addItem("buy sushi", "$", 5.1);
        assertThrows(InvalidNumberException.class, () -> c1.execute(spendingList, null, ui));
        ClearSpendingListCommand c2 = new ClearSpendingListCommand(false, 1);
        c2.execute(spendingList, null, ui);
        assertEquals(1, spendingList.getListSize());
        c2.execute(spendingList, null, ui);
        assertEquals(0, spendingList.getListSize());
    }

    @Test
    void execute_clearAll() throws IOException, InvalidClearSpendingException, InvalidNumberException {
        ClearSpendingListCommand c = new ClearSpendingListCommand(true, 0);
        SpendingList spendingList = new SpendingList();
        Ui ui = new Ui();
        spendingList.addItem("buy chicken rice", "$", 3.0);
        spendingList.addItem("buy sushi", "$", 5.1);
        c.execute(spendingList, null, ui);
        assertEquals(0, spendingList.getListSize());
        assertThrows(InvalidClearSpendingException.class, () -> c.execute(spendingList, null, ui));
    }

}