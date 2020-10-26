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

    public AddCommand(String description, String symbol, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.symbol = symbol;
        this.category = category;
    }
    
    private final String[][] exchangeRates = {
            {"SGD USD", "USD SGD", "SGD CNY", "CNY SGD"},
            {"0.74", "1.36", "4.99", "0.20"},
    };
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        logger.log(Level.FINE, "going to add item");
        if (!symbol.equals("SGD")) {
            updateAmount();
            updateCurrency();
        }
        spendingList.addItem(description, symbol, amount, category);
        ui.printAdd(spendingList);
        int size = spendingList.getListSize();
        if (size > 1) {
            SpendingListCategoriser spendingListCategoriser = new SpendingListCategoriser();
            spendingListCategoriser.execute(spendingList);
        }
        if (size % 8 == 0) {
            EncouragementCommand encouragementCommand = new EncouragementCommand();
            encouragementCommand.execute(spendingList, ui);
        }
        if (Budget.hasBudget) {
            WarnCommand warnCommand = new WarnCommand();
            warnCommand.execute(spendingList, ui);
        }
    }
    
    //@@author killingbear999
    private void updateAmount() {
        if (symbol.equals("USD")) {
            amount = amount * Double.parseDouble(exchangeRates[1][1]);
        } else if (symbol.equals("CNY")) {
            amount = amount * Double.parseDouble(exchangeRates[1][3]);
        }
    }
    
    private void updateCurrency() {
        symbol = "SGD";
    }
}