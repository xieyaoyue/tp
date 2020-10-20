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
            if (i.getYearMonth().contains(period)) {
                totalAmount += i.getAmount();
            }
        }
        return totalAmount;
    }
    
    public void editItem(int number, String description, String symbol, double amount) throws IOException {
        Item item = getItem(number);
        item.editDescription(description);
        item.editSymbol(symbol);
        item.editAmount(amount);
        save();
    }

    public void updateSpendingList() throws IOException {
        ConvertCommand convertCommand = new ConvertCommand(description);
        spendingList = convertCommand.updateSpendingList();
        save();
    }
    
    public double getCurrentAmount() {
        double currentAmount = 0;
        for (Item i: spendingList) {
            currentAmount += i.getAmount();
        }
        return currentAmount;
    }
}
