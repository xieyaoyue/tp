package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.util.ArrayList;
import java.util.Set;

public class SetBudgetCommand extends Command {
    
    private double budgetLimit;
    private String currency;
    public static ArrayList<Double> budget = new ArrayList<>();
    
    public SetBudgetCommand(String currency, double budgetLimit) {
        this.currency = currency;
        this.budgetLimit = budgetLimit;
    }
    
    public SetBudgetCommand() {}
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) {
        budget.add(budgetLimit);
        ui.printBudgetLimit(currency, budgetLimit);
    }
    
    public double getBudgetLimit() {
        return budget.get(0);
    }
    
    public void updateList(double newBudgetLimit) {
        budget.clear();
        budget.add(newBudgetLimit);
    }
}
