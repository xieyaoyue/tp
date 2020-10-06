package seedu.duke;

import java.util.ArrayList;

public class ConvertCommand {
    
    private final String description;
    private String currencies;
    private double exchangeRate;
    public static ArrayList<String> newSpendingList = new ArrayList<>();
    
    /** SGD to USD; USD to SGD; SGD to Yuan; Yuan to SGD */
    private final String[][] exchangeRates = {{"SGDUSD", "USDSGD", "SGDYuan", "YuanSGD"},
            {"0.74", "1.36", "4.99", "0.20"}};
    
    public ConvertCommand(String description) {
        this.description = description;
    }
    
    private void retrieveSpendingList(SpendingList spendingList) {
        newSpendingList = spendingList.getSpendingList();
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
    
    public void execute(String spendingList) {
        retrieveSpendingList();
        identifyCurrency(description);
        findExchangeRate();
        for (int i = 0; i < newSpendingList.size(); i++) {
            String currentString = newSpendingList.get(i);
            newSpendingList.remove(i);
            int amountPosition = getAmountPosition(amountPosition, currentString);
            updateNewAmount(amountPosition, currentString);
            updateCurrency(currentString);
            newSpendingList.add(currentString);
        }
    }
    
    private void updateNewAmount(int amountPosition, String currentString) {
        int length = currentString.length();
        String amount = currentString.substring(amountPosition,length);
        double newAmount = Double.parseDouble(amount);
        newAmount = newAmount * exchangeRate;
        currentString.replace(amount, Double.toString(newAmount));
    }
    
    private void updateCurrency(String currentString) {
        switch (currencies) {
        case "SGDUSD":
            currentString.replace("S$", "$");
            break;
        case "USDSGD":
            currentString.replace("$", "S$");
            break;
        case "SGDYuan":
            currentString.replace("S$", "￥");
            break;
        case "YuanSGD":
            currentString.replace("￥", "S$");
            break;
        }
    }
    
    private int getAmountPosition(int amountPosition, String currentString) {
        if (currentString.contains("$")) {
            amountPosition = currentString.indexOf("$") + 1;
        } else if (currentString.contains("￥")) {
            amountPosition = currentString.indexOf("￥") + 1;
        }
        return amountPosition;
    }
    
    public ArrayList<String> returnSpendingList() {
        return newSpendingList;
    }
}
