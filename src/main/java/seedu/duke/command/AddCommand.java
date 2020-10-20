package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCommand extends Command {

    public String description;
    public double amount;
    public String symbol;
    private static Logger logger = Logger.getLogger("AddCommand");

    public AddCommand(String description, String symbol, double amount) {
        this.description = description;
        this.amount = amount;
        this.symbol = symbol;
    }
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        logger.log(Level.FINE, "going to add item");
        spendingList.addItem(description, symbol, amount);
        ui.printAdd(spendingList);
        
        SetBudgetCommand setBudgetCommand = new SetBudgetCommand();
        int size = setBudgetCommand.getListSize();
        if (size > 0) {
            WarnCommand warnCommand = new WarnCommand();
            warnCommand.execute(spendingList, ui);
        }
    }
}