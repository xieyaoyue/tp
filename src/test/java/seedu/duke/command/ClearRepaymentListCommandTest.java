package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.InvalidClearBudgetException;
import seedu.duke.exceptions.InvalidClearRepaymentException;
import seedu.duke.exceptions.InvalidNumberException;
import seedu.duke.ui.Ui;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@@author xieyaoyue
class ClearRepaymentListCommandTest {
    @Test
    void execute_clearIndex() throws IOException, InvalidClearRepaymentException, InvalidNumberException {
        RepaymentList repaymentList1 = new RepaymentList();
        repaymentList1.addItem("John", "SGD", 10.00, "1 Nov 2020");
        RepaymentList repaymentList2 = new RepaymentList();
        repaymentList2.addItem("Ben", "USD", 20.00, "10 Nov 2020");
        Ui ui = new Ui();
        ClearRepaymentListCommand c1 = new ClearRepaymentListCommand(false, 3);
        assertThrows(InvalidNumberException.class, () -> c1.execute(null, repaymentList1, ui));
        ClearRepaymentListCommand c2 = new ClearRepaymentListCommand(false, 1);
        c2.execute(null, repaymentList2, ui);
        assertEquals(0, repaymentList2.getListSize());
        assertThrows(InvalidClearRepaymentException.class, () -> c2.execute(null, repaymentList2, ui));
    }

    @Test
    void execute_clearAll() throws IOException, InvalidClearRepaymentException, InvalidNumberException {
        RepaymentList repaymentList1 = new RepaymentList();
        repaymentList1.addItem("John", "SGD", 10.00, "1 Nov 2020");
        RepaymentList repaymentList2 = new RepaymentList();
        repaymentList2.addItem("Ben", "USD", 20.00, "10 Nov 2020");
        Ui ui = new Ui();
        ClearRepaymentListCommand c = new ClearRepaymentListCommand(true, 0);
        c.execute(null, repaymentList2, ui);
        assertEquals(0, repaymentList2.getListSize());
        assertThrows(InvalidClearRepaymentException.class, () -> c.execute(null, repaymentList2, ui));
    }
}