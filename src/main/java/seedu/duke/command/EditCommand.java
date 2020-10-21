package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

//@@author killingbear999
public class EditCommand extends Command {
    
    private String description;
    private double amount;
    private String symbol;
    private int index;
    
    public EditCommand(int index, String description, String symbol, double amount) {
        this.index = index;
        this.description = description;
        this.amount = amount;
        this.symbol = symbol;
    }
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        spendingList.editItem(index, description, symbol, amount);
        ui.printEdit(spendingList, index);
    }
}
