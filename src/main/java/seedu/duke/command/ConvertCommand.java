package seedu.duke.command;

import seedu.duke.Item;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class ConvertCommand extends Command {

    private final String description;
    private String currencies;
    private String outputCurrency;
    private double exchangeRate;
    public static ArrayList<Item> newSpendingList = new ArrayList<>();

    /** SGD to USD; USD to SGD; SGD to Yuan; Yuan to SGD. */
    private final String[][] exchangeRates = {
            {"SGD USD", "USD SGD", "SGD Yuan", "Yuan SGD"},
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
    }

    private void updateNewAmount(Item currentString) {
        double amount = currentString.getAmount();
        assert amount == amount * exchangeRate : "Incorrect new amount";
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
        case "SGD Yuan":
            currentString.editSymbol("¥");
            break;
        case "Yuan SGD":
            currentString.editSymbol("S$");
            break;
        default:
        }
    }

    public ArrayList<Item> updateSpendingList() {
        return newSpendingList;
    }
}
