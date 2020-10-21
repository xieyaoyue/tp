package seedu.duke;

import seedu.duke.category.Item;
import seedu.duke.command.ConvertCommand;

import java.io.IOException;
import java.util.ArrayList;

public class SpendingList {
    private ArrayList<Item> spendingList;
    private String description;
    private Storage storage;

    public SpendingList(String description, ArrayList<Item> spendingList, Storage storage) {
        this.description = description;
        this.spendingList = spendingList;
        this.storage = storage;
    }
    
    public SpendingList() {
    }

    public SpendingList(String description, Storage storage) {
        this(description, new ArrayList<>(), storage);
    }

    public SpendingList(Storage storage) {
        this("", storage);
    }

    public SpendingList(ArrayList<Item> spendingList) {
        this("", spendingList, null);
    }

    private void save() throws IOException {
        if (storage == null) {
            return;
        }
        storage.save(this);
    }

    public void addItem(String description, String symbol, double amount, String category) throws IOException {
        Item item = new Item(description, symbol, amount, category);
        spendingList.add(item);
        save();
    }

    public void addItem(String description, String symbol, double amount) throws IOException {
        Item item = new Item(description, symbol, amount);
        spendingList.add(item);
        save();
    }

    public void deleteItem(int index) throws IOException {
        spendingList.remove(index);
        save();
    }

    public void clearAllItems() throws IOException {
        spendingList.clear();
        assert getListSize() == 0 : "list size should be 0";
        save();
    }

    public Item getItem(int index) {
        return spendingList.get(index);
    }

    public int getListSize() {
        return spendingList.size();
    }

    public ArrayList<Item> getSpendingList() {
        return spendingList;
    }

    public double getSpendingAmount(String period) {
        double totalAmount = 0;
        for (Item i: spendingList) {
            if (i.getDate().contains(period)) {
                totalAmount += i.getAmount();
            }
        }
        return totalAmount;
    }
    
    //@@author killingbear999
    public void editItem(int number, String description, String symbol, double amount, String category)
            throws IOException {
        Item item = getItem(number);
        item.editDescription(description);
        item.editSymbol(symbol);
        item.editAmount(amount);
        item.editCategory(category);
        save();
    }

    //@@author killingbear999
    public void updateSpendingList() throws IOException {
        ConvertCommand convertCommand = new ConvertCommand(description);
        spendingList = convertCommand.updateSpendingList();
        save();
    }
    
    //@@author killingbear999
    public double getCurrentAmount() {
        double currentAmount = 0;
        for (Item i: spendingList) {
            currentAmount += i.getAmount();
        }
        return currentAmount;
    }
    
    //@@author killingbear999
    private void swapItem(Item item1, Item item2) {
        String tempCategory = item1.getCategory();
        String tempDescription = item1.getDescription();
        String tempSymbol = item1.getSymbol();
        String tempDate = item1.getDate();
        double tempAmount = item1.getAmount();
        
        item1.editCategory(item2.getCategory());
        item1.editDescription(item2.getDescription());
        item1.editSymbol(item2.getSymbol());
        item1.editAmount(item2.getAmount());
        item1.editDate(item2.getDate());
    
        item2.editCategory(tempCategory);
        item2.editDescription(tempDescription);
        item2.editSymbol(tempSymbol);
        item2.editAmount(tempAmount);
        item2.editDate(tempDate);
    }
    
    //@@author killingbear999
    public void categoriseSpendingList() {
        int count = spendingList.size();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < spendingList.size(); j++) {
                Item currentItem = getItem(j);
                if (i == 0 && currentItem.getCategory().equals("Education")) {
                    Item lastItem = getItem(count);
                    swapItem(currentItem, lastItem);
                    count = count - 1;
                } else if (i == 1 && currentItem.getCategory().equals("Entertainment")) {
                    Item lastItem = getItem(count);
                    swapItem(currentItem, lastItem);
                    count = count - 1;
                } else if (i == 2 && currentItem.getCategory().equals("Food")) {
                    Item lastItem = getItem(count);
                    swapItem(currentItem, lastItem);
                    count = count - 1;
                } else if (i == 3 && currentItem.getCategory().equals("Health")) {
                    Item lastItem = getItem(count);
                    swapItem(currentItem, lastItem);
                    count = count - 1;
                } else if (i == 4 && currentItem.getCategory().equals("Transportation")) {
                    Item lastItem = getItem(count);
                    swapItem(currentItem, lastItem);
                    count = count - 1;
                } else if (i == 5 && currentItem.getCategory().equals("Utilities")) {
                    Item lastItem = getItem(count);
                    swapItem(currentItem, lastItem);
                    count = count - 1;
                } else if (i == 6 && currentItem.getCategory().equals("Other")) {
                    Item lastItem = getItem(count);
                    swapItem(currentItem, lastItem);
                    count = count - 1;
                }
            }
        }
    }
}
