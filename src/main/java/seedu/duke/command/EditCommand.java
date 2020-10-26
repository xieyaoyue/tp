package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

//@@author killingbear999
public class EditCommand extends Command {
    public String description;
    public Double amount;
    public String symbol;
    public int index;
    public String category;

    // TODO : allow null @killingbear999
    public EditCommand(int index, String description, String symbol, Double amount, String category) {
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
