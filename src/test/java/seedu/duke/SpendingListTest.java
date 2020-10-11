package seedu.duke;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpendingListTest {
    private SpendingList spendingList = new SpendingList();
    private SpendingList itemList = new SpendingList(new ArrayList<>(
            List.of(new Item("rice", "S$", 2),
                    new Item("noodle", "S$", 1.5),
                    new Item("fish", "S$", 10),
                    new Item("books", "S$", 8.9))));

    @Test
    public void addItem() {
        Item expectedItem = new Item("buy book", "S$", 10);
        SpendingList expectedList = new SpendingList(new ArrayList<>(
                List.of(expectedItem)));

        spendingList.addItem("buy book", "S$", 10);

        assert spendingList.getListSize() == 1 : "item not added";
        assert Arrays.toString(spendingList.getSpendingList().toArray())
                .equals(Arrays.toString(expectedList.getSpendingList().toArray())) : "different";
    }

    @Test
    public void deleteItem() {
        SpendingList expectedList = new SpendingList(new ArrayList<>(
                List.of(new Item("noodle", "S$", 1.5),
                        new Item("fish", "S$", 10),
                        new Item("books", "S$", 8.9))));

        itemList.deleteItem(0);

        assert itemList.getListSize() == 3 : "item is not deleted";
        assert Arrays.toString(itemList.getSpendingList().toArray())
                .equals(Arrays.toString(expectedList.getSpendingList().toArray())) : "different";
    }

    @Test
    public void getItem() {
        spendingList.addItem("buy book", "S$", 10);
        assertEquals(spendingList.getItem(0).description, "buy book");
        assertEquals(spendingList.getItem(0).symbol, "S$");
        assertEquals(spendingList.getItem(0).amount, 10);
    }

    @Test
    public void getListSize() {
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
    public void clearAllItems() {
        spendingList.addItem("buy book", "S$", 10);
        spendingList.addItem("buy stationary", "S$", 5);
        spendingList.clearAllItems();
        assertEquals(spendingList.getListSize(), 0);

        itemList.clearAllItems();
        assert itemList.getListSize() == 0 : "list is not cleared";
        assert Arrays.toString(itemList.getSpendingList().toArray())
                .equals(Arrays.toString(spendingList.getSpendingList().toArray())) : "different";
    }

    @Test
    public void editItem() {
        spendingList.addItem("buy book", "S$", 10);
        spendingList.editItem(0, "buy book", "S$", 12);
        assertEquals(spendingList.getItem(0).amount, 12);
    }

    @Test
    public void getSpendingAmount() {
        double expectedAmount = 22.4;
        assertEquals(itemList.getSpendingAmount("2020"), expectedAmount);
    }
}