package seedu.duke;

import java.util.ArrayList;

public class SpendingList {
    private ArrayList<Item> spendingList;
    private String description;

    public SpendingList(ArrayList<Item> spendingList) {
        this.spendingList = spendingList;
    }
    
    public SpendingList(String description) {
        this.description = description;
    }
    
    public void addItem(String description, String symbol, double amount) {
        Item item = new Item(description, symbol, amount);
        spendingList.add(item);
    }

    public void deleteItem(int index) {
        spendingList.remove(index);
    }

    public void clearAllItems() {
        spendingList.clear();
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

    public void updateSpendingList() {
        ConvertCommand convertCommand = new ConvertCommand(description);
        spendingList = convertCommand.updateSpendingList();
    }
}
