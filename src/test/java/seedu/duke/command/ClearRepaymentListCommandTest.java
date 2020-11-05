package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.RepaymentList;
import seedu.duke.exceptions.InvalidClearRepaymentException;
import seedu.duke.ui.Ui;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClearRepaymentListCommandTest {
    @Test
    void execute_clearIndex() throws IOException, InvalidClearRepaymentException {
        RepaymentList repaymentList1 = new RepaymentList();
        repaymentList1.addItem("John", "SGD", 10.00, "1 Nov 2020");
        RepaymentList repaymentList2 = new RepaymentList();
        repaymentList2.addItem("Ben", "USD", 20.00, "10 Nov 2020");
        Ui ui = new Ui();
        ClearRepaymentListCommand c = new ClearRepaymentListCommand(false, 1);
        c.execute(null, repaymentList2, ui);
        assertEquals(0, repaymentList2.getListSize());
    }

    @Test
    void execute_clearAll() throws IOException, InvalidClearRepaymentException {
        RepaymentList repaymentList1 = new RepaymentList();
        repaymentList1.addItem("John", "SGD", 10.00, "1 Nov 2020");
        RepaymentList repaymentList2 = new RepaymentList();
        repaymentList2.addItem("Ben", "USD", 20.00, "10 Nov 2020");
        Ui ui = new Ui();
        ClearRepaymentListCommand c = new ClearRepaymentListCommand(true, 0);
        c.execute(null, repaymentList2, ui);
        assertEquals(0, repaymentList2.getListSize());
    }
}