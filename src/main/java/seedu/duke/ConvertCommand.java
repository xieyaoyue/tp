package seedu.duke;

import java.util.ArrayList;

public class ConvertCommand {
    
    private String description;
    private String currencies;
    private String inputCurrency;
    private String outputCurrency;
    private double exchangeRate;
    public static ArrayList<String> newSpendingList = new ArrayList<>();
    
    /** SGD to USD; USD to SGD; SGD to Yuan; Yuan to SGD */
    private String[][] exchangeRates = {{"SGDUSD", "USDSGD", "SGDYuan", "YuanSGD"},
            {"0.74", "1.36", "4.99", "0.20"}};
    
    public ConvertCommand(String description) {
        this.description = description;
    }
    
    public ConvertCommand(ArrayList<String> spendingList) {
        this.newSpendingList = spendingList;
    }
    
    private void identifyCurrency(String description) {
        int firstBlankSpacePosition = description.indexOf(" ") + 1;
        int secondBlankSpacePosition = description.indexOf(" ", firstBlankSpacePosition) + 1;
        int length = description.length();
        inputCurrency = description.substring(firstBlankSpacePosition, secondBlankSpacePosition);
        outputCurrency = description.substring(secondBlankSpacePosition, length);
        currencies = inputCurrency + outputCurrency;
    }
    
    private void findExchangeRate() {
        for (int i = 0; i < 4; i++) {
            if (exchangeRates[0][i] == currencies) {
                exchangeRate = Double.parseDouble(exchangeRates[1][i]);
                break;
            }
        }
    }
    
    public void execute(String spendingList) {
        identifyCurrency(description);
        findExchangeRate();
        for (int i = 0; i < newSpendingList.size(); i++) {
            String currentString = newSpendingList.get(i);
            newSpendingList.remove(i);
            int amountPosition = currentString.indexOf(inputCurrency) + inputCurrency.length() + 1;
            int length = currentString.length();
            String amount = currentString.substring(amountPosition,length);
            double newAmount = Double.parseDouble(amount);
            newAmount = newAmount * exchangeRate;
            currentString.replace(amount, Double.toString(newAmount));
            newSpendingList.add(currentString);
        }
    }
    
    public ArrayList<String> returnSpendingList() {
        return newSpendingList;
    }
}
