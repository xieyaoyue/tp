package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidClearBudgetException;
import seedu.duke.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


//@@author xieyaoyue
class ClearBudgetCommandTest {

    @Test
    void execute() throws InvalidClearBudgetException {
        ClearBudgetCommand c = new ClearBudgetCommand();
        Budget.addBudget("SGD", 100);
        SpendingList spendingList = new SpendingList();
        RepaymentList repaymentList = new RepaymentList();
        Ui ui = new Ui();
        c.execute(spendingList, repaymentList, ui);
        assertFalse(Budget.hasBudget);
        assertThrows(InvalidClearBudgetException.class, () -> c.execute(spendingList, repaymentList, ui));
    }
}