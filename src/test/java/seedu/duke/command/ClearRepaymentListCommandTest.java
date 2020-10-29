package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.RepaymentList;
import seedu.duke.Ui;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClearRepaymentListCommandTest {
    @Test
    void execute_clearIndex() throws IOException {
        RepaymentList repaymentList1 = new RepaymentList("John", "SGD", 10.00, "1 Nov 2020");
        repaymentList1.storeCurrentString();
        RepaymentList repaymentList2 = new RepaymentList("Ben", "USD", 20.00, "10 Nov 2020");
        repaymentList2.storeCurrentString();
        Ui ui = new Ui();
        ClearRepaymentListCommand c = new ClearRepaymentListCommand(false, 1);
        c.execute(null, repaymentList2, ui);
        assertEquals(1, repaymentList2.getListSize());
    }

    @Test
    void execute_clearAll() throws IOException {
        RepaymentList repaymentList1 = new RepaymentList("John", "SGD", 10.00, "1 Nov 2020");
        repaymentList1.storeCurrentString();
        RepaymentList repaymentList2 = new RepaymentList("Ben", "USD", 20.00, "10 Nov 2020");
        repaymentList2.storeCurrentString();
        Ui ui = new Ui();
        ClearRepaymentListCommand c = new ClearRepaymentListCommand(true, 0);
        c.execute(null, repaymentList2, ui);
        assertEquals(0, repaymentList2.getListSize());
    }
}