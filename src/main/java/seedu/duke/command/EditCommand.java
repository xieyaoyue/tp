package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

public class EditCommand extends Command {
    
    public String description;
    public double amount;
    public String symbol;
    public int index;
    
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
