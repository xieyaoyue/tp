package seedu.duke;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpendingListTest {
    @Test
    public void addItem() throws IOException {
        SpendingList expectedList = initList(
                new Item("buy book", "S$", 10)
        );

        SpendingList realList = new SpendingList((Storage) null);
        realList.addItem("buy book", "S$", 10);

        assert realList.getListSize() == 1 : "item not added";
        assertEqualList(expectedList, realList);
    }

    private void assertEqualList(SpendingList expectedList, SpendingList realList) {
        String expectedString = Arrays.toString(expectedList.getSpendingList().toArray());
        String realString = Arrays.toString(realList.getSpendingList().toArray());
        assert expectedString.equals(realString) : "different";
    }

    private SpendingList initList(Item... items) {
        return new SpendingList(new ArrayList<>(Arrays.asList(items)));
    }

    @Test
    public void deleteItem() throws IOException {
        SpendingList expectedList = initList(
                new Item("noodle", "S$", 1.5),
                new Item("fish", "S$", 10),
                new Item("books", "S$", 8.9)
        );

        SpendingList realList = initList(
                new Item("rice", "S$", 2),
                new Item("noodle", "S$", 1.5),
                new Item("fish", "S$", 10),
                new Item("books", "S$", 8.9)
        );
        realList.deleteItem(0);

        assert realList.getListSize() == 3 : "item is not deleted";
        assertEqualList(expectedList, realList);
    }

    @Test
    public void getItem() {
        SpendingList realList = initList(
                new Item("buy book", "S$", 10)
        );

        Item firstItem = realList.getItem(0);
        assertEquals(firstItem.description, "buy book");
        assertEquals(firstItem.symbol, "S$");
        assertEquals(firstItem.amount, 10);
    }

    @Test
    void getListSize() throws IOException {
        SpendingList realList = new SpendingList((Storage) null);

        realList.addItem("buy book", "S$", 10);
        assertEquals(realList.getListSize(), 1);

        realList.addItem("buy stationary", "S$", 5);
        assertEquals(realList.getListSize(), 2);

        realList.deleteItem(0);
        assertEquals(realList.getListSize(), 1);

        realList.addItem("buy grocery", "S$", 10);
        assertEquals(realList.getListSize(), 2);
    }

    @Test
    void clearAllItems() throws IOException {
        SpendingList expectedList = new SpendingList((Storage) null);
        SpendingList realList = initList(
                new Item("buy book", "S$", 10),
                new Item("buy stationary", "S$", 5)
        );
        realList.clearAllItems();

        assert realList.getListSize() == 0 : "list is not cleared";
        assertEqualList(expectedList, realList);
    }

    @Test
    void editItem() throws IOException {
        SpendingList realList = initList(
                new Item("buy book", "S$", 10)
        );
        realList.editItem(0, "buy book", "S$", 12);

        assertEquals(realList.getItem(0).amount, 12);
    }

    @Test
    public void getSpendingAmount() {
        double expectedAmount = 22.4;
        String expectedYear = Integer.toString(LocalDate.now().getYear());

        SpendingList realList = initList(
                new Item("rice", "S$", 2),
                new Item("noodle", "S$", 1.5),
                new Item("fish", "S$", 10),
                new Item("books", "S$", 8.9)
        );

        assertEquals(realList.getSpendingAmount(expectedYear), expectedAmount);
    }
}
