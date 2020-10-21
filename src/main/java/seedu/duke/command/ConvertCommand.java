package seedu.duke.command;

import seedu.duke.Budget;
import seedu.duke.category.Item;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

//@@author killingbear999
public class ConvertCommand extends Command {

    private String description;
    private String currencies;
    private String outputCurrency;
    private double exchangeRate = 1.0;
    public static ArrayList<Item> newSpendingList = new ArrayList<>();
    private static Logger logger = Logger.getLogger("ConvertCommand");

    /** SGD to USD; USD to SGD; SGD to CNY; CNY to SGD. */
    private final String[][] exchangeRates = {
            {"SGD USD", "USD SGD", "SGD CNY", "CNY SGD"},
            {"0.74", "1.36", "4.99", "0.20"},
    };

    public ConvertCommand(String description) {
        this.description = description;
    }

    public String identifyCurrency(String description) {
        int firstCurrencyStartingPosition = description.indexOf(" ") + 1;
        assert firstCurrencyStartingPosition == 3 : "The value of firstCurrencyStartingPosition should be 3";
        int firstCurrencyEndingPosition = description.indexOf("-d", firstCurrencyStartingPosition);
        int secondCurrencyStartingPosition = description.indexOf("-d", firstCurrencyStartingPosition) + 3;
        int length = description.length();
        String inputCurrency = description.substring(firstCurrencyStartingPosition, firstCurrencyEndingPosition);
        assert inputCurrency.equals(description.substring(firstCurrencyStartingPosition, firstCurrencyEndingPosition)) :
                "Incorrect input currency";
        outputCurrency = description.substring(secondCurrencyStartingPosition, length);
        assert outputCurrency.equals(description.substring(secondCurrencyStartingPosition, length)) :
                "Incorrect output currency";
        return inputCurrency + outputCurrency;
    }

    private void findExchangeRate() {
        for (int i = 0; i < 4; i++) {
            if (exchangeRates[0][i].equals(currencies)) {
                exchangeRate = Double.parseDouble(exchangeRates[1][i]);
                assert exchangeRate == Double.parseDouble(exchangeRates[1][i]) : "Incorrect exchange rate";
                break;
            }
        }
    }

    @Override
    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        logger.log(Level.FINE, "going to start processing");
        newSpendingList = spendingList.getSpendingList();
        currencies = identifyCurrency(description);
        findExchangeRate();
        for (int i = 0; i < newSpendingList.size(); i++) {
            Item currentString = newSpendingList.get(0);
            newSpendingList.remove(0);
            updateNewAmount(currentString);
            updateCurrency(currentString);
            newSpendingList.add(currentString);
        }
        ui.printConvertCurrency(outputCurrency);
        spendingList.updateSpendingList();
        updateBudgetList();
        logger.log(Level.FINE, "end of processing");
    }

    private void updateNewAmount(Item currentString) {
        double amount = currentString.getAmount();
        amount = amount * exchangeRate;
        currentString.editAmount(amount);
    }

    private void updateCurrency(Item currentString) {
        switch (currencies) {
        case "SGD USD":
            currentString.editSymbol("$");
            break;
        case "USD SGD":
            currentString.editSymbol("S$");
            break;
        case "SGD CNY":
            currentString.editSymbol("¥");
            break;
        case "CNY SGD":
            currentString.editSymbol("S$");
            break;
        default:
        }
    }
    
    public void updateBudgetList() {
        double budgetLimit = Budget.getBudgetLimit();
        double newBudgetLimit = budgetLimit * exchangeRate;
        Budget.updateBudget(outputCurrency, newBudgetLimit);
    }

    public ArrayList<Item> updateSpendingList() {
        return newSpendingList;
    }
}
