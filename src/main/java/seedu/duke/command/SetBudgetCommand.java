package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.util.ArrayList;

public class SetBudgetCommand extends Command {
    
    private double budgetLimit;
    private String currency;
    public static ArrayList<String> budget = new ArrayList<>();
    
    public SetBudgetCommand(String currency, double budgetLimit) {
        this.currency = currency;
        this.budgetLimit = budgetLimit;
    }
    
    public SetBudgetCommand() {}
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) {
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
