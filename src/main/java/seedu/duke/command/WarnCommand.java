package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

public class WarnCommand extends Command {
    
    private double budgetLimit;
    private double budgetThreshold;
    private String outputCurrency;
    private final double threshold = 0.9;
    
    public WarnCommand() {
    }
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) {
        SetBudgetCommand setBudgetCommand = new SetBudgetCommand();
        ConvertCommand convertCommand = new ConvertCommand();
        outputCurrency = convertCommand.getOutputCurrency();
        budgetLimit = setBudgetCommand.getBudgetLimit();
        budgetLimit = convertCommand.updateBudgetLimit();
        budgetThreshold = budgetLimit * threshold;
        double currentAmount = spendingList.getCurrentAmount();
        if (currentAmount >= budgetThreshold && currentAmount < budgetLimit) {
            double amountRemaining = currentAmount - budgetThreshold;
            ui.printApproachingWarningMessage(outputCurrency, amountRemaining);
        } else if (currentAmount >= budgetLimit) {
            ui.printExceedingWarningMessage();
        }
    }
}
