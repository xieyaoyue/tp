package seedu.duke.Command;

import seedu.duke.Command.Command;
import seedu.duke.Item;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.util.ArrayList;

public class ConvertCommand extends Command {
    
    private final String description;
    private String currencies;
    private double exchangeRate;
    public static ArrayList<Item> newSpendingList = new ArrayList<>();
    
    /** SGD to USD; USD to SGD; SGD to Yuan; Yuan to SGD */
    private final String[][] exchangeRates = {{"SGDUSD", "USDSGD", "SGDYuan", "YuanSGD"},
            {"0.74", "1.36", "4.99", "0.20"}};
    
    public ConvertCommand(String description) {
        this.description = description;
    }
    
    private void identifyCurrency(String description) {
        int firstBlankSpacePosition = description.indexOf(" ") + 1;
        int secondBlankSpacePosition = description.indexOf(" ", firstBlankSpacePosition) + 1;
        int length = description.length();
        String inputCurrency = description.substring(firstBlankSpacePosition, secondBlankSpacePosition);
        String outputCurrency = description.substring(secondBlankSpacePosition, length);
        currencies = inputCurrency + outputCurrency;
    }
    
    private void findExchangeRate() {
        for (int i = 0; i < 4; i++) {
            if (exchangeRates[0][i].equals(currencies)) {
                exchangeRate = Double.parseDouble(exchangeRates[1][i]);
                break;
            }
        }
    }
    
    public void execute(SpendingList spendingList, Ui ui) {
        newSpendingList = spendingList.getSpendingList();
        identifyCurrency(description);
        findExchangeRate();
        for (int i = 0; i < newSpendingList.size(); i++) {
            Item currentString = newSpendingList.get(i);
            newSpendingList.remove(i);
            updateNewAmount(currentString);
            updateCurrency(currentString);
            newSpendingList.add(currentString);
        }
    }
    
    private void updateNewAmount(Item currentString) {
        double amount = currentString.getAmount();
        amount = amount * exchangeRate;
        currentString.editAmount(amount);
    }
    
    private void updateCurrency(Item currentString) {
        switch (currencies) {
        case "SGDUSD":
            currentString.editSymbol("$");
            break;
        case "USDSGD":
            currentString.editSymbol("S$");
            break;
        case "SGDYuan":
            currentString.editSymbol("￥");
            break;
        case "YuanSGD":
            currentString.editSymbol("S$");
            break;
        }
    }
    
    public ArrayList<Item> updateSpendingList() {
        return newSpendingList;
    }
}
