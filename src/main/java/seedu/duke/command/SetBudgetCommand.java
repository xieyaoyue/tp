package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.util.ArrayList;

//@@author killingbear999
public class SetBudgetCommand extends Command {
    
    private String description;
    private double budgetLimit;
    private String currency;
    public static ArrayList<String> budget = new ArrayList<>();
    
    public SetBudgetCommand(String description) {
        this.description = description;
    }
    
    public SetBudgetCommand() {
    }
    
    private void identifyBudgetLimit(String description) {
        int currencyBeginIndex = description.indexOf("-s") + "-s".length() + 1;
        int currencyEndIndex = currencyBeginIndex + 3;
        int length = description.length();
        currency = description.substring(currencyBeginIndex, currencyEndIndex);
        budgetLimit = Double.parseDouble(description.substring(currencyEndIndex + 1, length));
    }
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) {
        identifyBudgetLimit(description);
        budget.clear();
        budget.add(currency);
        budget.add(Double.toString(budgetLimit));
        ui.printBudgetLimit(currency, budgetLimit);
    }
    
    public double getBudgetLimit() {
        return Double.parseDouble(budget.get(1));
    }
    
    public String getBudgetCurrency() {
        return budget.get(0);
    }
    
    public int getListSize() {
        return budget.size();
    }
    
    public void updateList(String outputCurrency, double newBudgetLimit) {
        budget.clear();
        budget.add(outputCurrency);
        budget.add(Double.toString(newBudgetLimit));
    }
}
