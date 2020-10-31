package seedu.duke.command;

import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.Ui;

//@@author killingbear999
public class WarnCommand extends Command {
    private double budgetLimit;
    private double budgetThreshold;
    private String outputCurrency;
    private final double threshold = 0.9;
    
    public WarnCommand() {
    }
    
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) {
        outputCurrency = Budget.getCurrency();
        budgetLimit = Budget.getBudgetLimit();
        budgetThreshold = budgetLimit * threshold;
        double currentAmount = spendingList.getCurrentAmount();
        if (currentAmount >= budgetThreshold && currentAmount < budgetLimit) {
            double amountRemaining = budgetLimit - currentAmount;
            ui.printApproachingWarningMessage(outputCurrency, amountRemaining);
        } else if (currentAmount >= budgetLimit) {
            ui.printExceedingWarningMessage();
        }
    }
}
