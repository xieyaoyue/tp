package seedu.duke;

import seedu.duke.category.Item;

import java.util.ArrayList;

//@@author killingbear999
public class SpendingListCategoriser {
    
    public static ArrayList<Item> newSpendingList = new ArrayList<>();
    
    public SpendingListCategoriser() {
    }
    
    // not finish yet
    public void execute(SpendingList spendingList) {
        int count = 0;
        newSpendingList = spendingList.getSpendingList();
        for (int i = 0; i < newSpendingList.size(); i++) {
        }
    }
    
}
