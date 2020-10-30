package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.category.Category;
import seedu.duke.exceptions.InvalidMonthException;

import java.util.logging.Level;
import java.util.logging.Logger;

//@@author pinfang
public class SummaryCommand extends DateCommand {
    private String period;
    private static final Logger logger = Logger.getLogger("SummaryCommand");
    private final DateFormatter dateFormatter = new DateFormatter();

    //@@author pinfang
    public SummaryCommand(String year, String month) {
        String monthFormat = dateFormatter.changeMonthFormat(month);
        if (monthFormat == null) {
            period = year;
        } else {
            period = year + "-" + monthFormat;
        }
    }

    public SummaryCommand() {
        period = "-";
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws InvalidMonthException {
        logger.log(Level.FINE, "going to start processing");
        double amountSpent = spendingList.getSpendingAmountTime(period);
        logger.log(Level.FINE, "end of processing");
        ui.printSummaryMessage(amountSpent);
        for (Category c : Category.values()) {
            double categoryAmountSpent = spendingList.getSpendingAmountCategory(c.toString(), period);
            ui.printSummaryCategory(c.name(), categoryAmountSpent);
        }
    }
}
