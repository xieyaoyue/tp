package seedu.duke.command;

import seedu.duke.Budget;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.util.ArrayList;

//@@author killingbear999
public class SetBudgetCommand extends Command {
    
    private String description;

    private double budgetLimit;
    private String currency;

    
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
        Budget.addBudget(currency, budgetLimit);
        ui.printBudgetLimit(currency, budgetLimit);
    }
}
