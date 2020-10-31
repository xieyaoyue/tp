package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PurgeDataCommandTest {
    @Test
    void execute() throws IOException {
        SpendingList spendingList = new SpendingList();
        spendingList.addItem("buy chicken rice", "$", 3.0);
        spendingList.addItem("buy sushi", "$", 5.1);
        Budget.addBudget("SGD", 100);
        RepaymentList repaymentList = new RepaymentList();
        repaymentList.addItem("John","USD",123,"2020-02-20");
        repaymentList = new RepaymentList();
        repaymentList.addItem("John","USD",123,"2020-02-20");
        assertEquals(1,repaymentList.getListSize());
        PurgeDataCommand purgeDataCommand = new PurgeDataCommand();
        Ui ui = new Ui();
        purgeDataCommand.execute(spendingList, repaymentList, ui);
        assertFalse(Budget.hasBudget);
        assertEquals(0, spendingList.getListSize());
        assertEquals(0, repaymentList.getListSize());
    }
}