package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.Budget;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClearBudgetCommandTest {

    @Test
    void execute() {
        Budget.addBudget("SGD", 100);
        assertTrue(Budget.hasBudget);
        Budget.clearBudget();
        assertFalse(Budget.hasBudget);
    }
}