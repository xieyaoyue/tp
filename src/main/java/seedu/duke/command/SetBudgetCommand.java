package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class SetBudgetCommand extends Command {
    
    private double budgetLimit;
    private String currency;
    
    public SetBudgetCommand(String currency, double budgetLimit) {
        this.currency = currency;
        this.budgetLimit = budgetLimit;
    }
    
    public SetBudgetCommand() {}
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) {
        ui.printBudgetLimit(currency, budgetLimit);
    }
    
    public double getBudgetLimit() {
        return budgetLimit;
    }
}
