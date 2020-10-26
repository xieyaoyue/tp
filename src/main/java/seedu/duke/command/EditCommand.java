package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

//@@author killingbear999
public class EditCommand extends Command {
    
    private String description;
    private double amount;
    private int index;
    private boolean isCategory = false;
    private boolean isDescription = false;
    private boolean isAmount = false;
    
    public EditCommand(int index, String description, boolean isCategory, boolean isDescription) {
        this.index = index;
        this.description = description;
        this.isCategory = isCategory;
        this.isDescription = isDescription;
    }
    
    public EditCommand(int index, double amount, boolean isAmount) {
        this.index = index;
        this.amount = amount;
        this.isAmount = isAmount;
    }
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        if (isDescription) {
            spendingList.editItemDescription(index, description);
        } else if (isCategory) {
            spendingList.editItemCategory(index, description);
        } else if (isAmount) {
            spendingList.editItemAmount(index, amount);
        }
        ui.printEdit(spendingList, index);
    }
}
