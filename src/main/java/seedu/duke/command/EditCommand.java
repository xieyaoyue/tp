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
        this.amount = amount;
        this.symbol = symbol;
        this.category = category;
    }
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        spendingList.editItem(index, description, symbol, amount, category);
        ui.printEdit(spendingList, index);
    }
}
