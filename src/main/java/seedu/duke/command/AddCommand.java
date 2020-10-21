package seedu.duke.command;

import seedu.duke.Budget;
import seedu.duke.SpendingList;
import seedu.duke.SpendingListCategoriser;
import seedu.duke.Ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCommand extends Command {

    public String description;
    public double amount;
    public String symbol;
    public String category;
    private static Logger logger = Logger.getLogger("AddCommand");

    public AddCommand(String description, String symbol, double amount) {
        this.description = description;
        this.amount = amount;
        this.symbol = symbol;
    }

    public AddCommand(String description, String symbol, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.symbol = symbol;
        this.category = category;
    }
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        logger.log(Level.FINE, "going to add item");
        spendingList.addItem(description, symbol, amount, category);
        ui.printAdd(spendingList);
        SpendingListCategoriser spendingListCategoriser = new SpendingListCategoriser();
        //spendingListCategoriser.execute();
        if (Budget.hasBudget) {
            WarnCommand warnCommand = new WarnCommand();
            warnCommand.execute(spendingList, ui);
        }
    }
}