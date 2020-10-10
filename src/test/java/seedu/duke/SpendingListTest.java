package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpendingListTest {

    private SpendingList spendingList = new SpendingList();

    @Test
    void getItem() {
        spendingList.addItem("buy book", "S$", 10);
        assertEquals(spendingList.getItem(0).description, "buy book");
        assertEquals(spendingList.getItem(0).symbol, "S$");
        assertEquals(spendingList.getItem(0).amount, 10);
    }

    @Test
    void getListSize() {
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
    void clearAllItems() {
        spendingList.addItem("buy book", "S$", 10);
        spendingList.addItem("buy stationary", "S$", 5);
        spendingList.clearAllItems();
        assertEquals(spendingList.getListSize(), 0);
    }

    @Test
    void editItem() {
        spendingList.addItem("buy book", "S$", 10);
        spendingList.editItem(0, "buy book", "S$", 12);
        assertEquals(spendingList.getItem(0).amount, 12);
    }
}