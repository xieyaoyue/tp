package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.Budget;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ClearBudgetCommandTest {

    @Test
    void execute() {
        Budget.addBudget("SGD", 100);
        Budget.clearBudget();
        assertFalse(Budget.hasBudget);
    }
}