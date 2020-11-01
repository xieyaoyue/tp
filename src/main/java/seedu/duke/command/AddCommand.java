package seedu.duke.command;

import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.utilities.SpendingListCategoriser;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCommand extends Command {
    public String description;
    public double amount;
    public String currency;
    public String category;
    private String defaultCurrency = "SGD";
    private static Logger logger = Logger.getLogger("AddCommand");

    public AddCommand(String description, String symbol, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.currency = symbol;
        this.category = category;
    }
    
    private final String[][] exchangeRates = {
            {"SGDUSD", "USDSGD", "SGDCNY", "CNYSGD"},
            {"0.74", "1.36", "4.99", "0.20"},
    };
    
    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException {
        logger.log(Level.FINE, "going to add item");
        int size = spendingList.getListSize();
        if (size != 0) {
            defaultCurrency = spendingList.getItem(0).getSymbol();
        }
        if (!currency.equals(defaultCurrency)) {
            updateAmount();
            updateCurrency();
        }
        if (amount >= 0) {
            if (currency.equals("SGD") || currency.equals("USD") || currency.equals("CNY")) {
                spendingList.addItem(description, currency, amount, category);
                ui.printAdd(spendingList);
            } else {
                ui.printInvalidInputCurrency();
            }
        } else {
            ui.printInvalidAmount();
        }
        if (size > 1) {
            SpendingListCategoriser spendingListCategoriser = new SpendingListCategoriser();
            spendingListCategoriser.execute(spendingList);
        }
        if (size % 4 == 0) {
            EncouragementCommand encouragementCommand = new EncouragementCommand();
            encouragementCommand.execute(spendingList, null, ui);
        }
        if (Budget.hasBudget) {
            WarnCommand warnCommand = new WarnCommand();
            warnCommand.execute(spendingList, null, ui);
        }
    }
    
    //@@author killingbear999
    private void updateAmount() {
        if (currency.equals("USD") && defaultCurrency.equals("SGD")) {
            amount = Math.round(amount * Double.parseDouble(exchangeRates[1][1]) * 100.0) / 100.0;
        } else if (currency.equals("CNY") && defaultCurrency.equals("SGD")) {
            amount = Math.round(amount * Double.parseDouble(exchangeRates[1][3]) * 100.0) / 100.0;
        } else if (currency.equals("SGD") && defaultCurrency.equals("USD")) {
            amount = Math.round(amount * Double.parseDouble(exchangeRates[1][0]) * 100.0) / 100.0;
        } else if (currency.equals("SGD") && defaultCurrency.equals("CNY")) {
            amount = Math.round(amount * Double.parseDouble(exchangeRates[1][2]) * 100.0) / 100.0;
        }
    }
    
    private void updateCurrency() {
        currency = defaultCurrency;
    }
}
