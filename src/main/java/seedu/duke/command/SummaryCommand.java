package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.category.Category;
import seedu.duke.exceptions.InvalidMonthException;

import java.util.logging.Level;
import java.util.logging.Logger;

//@@author pinfang
public class SummaryCommand extends Command {
    private String year;
    private String month;
    private String period;
    private boolean isValidMonth = true;
    private static final Logger logger = Logger.getLogger("SummaryCommand");
    private final DateFormatter dateFormatter = new DateFormatter();

    //@@author pinfang
    public SummaryCommand(String year, String month) {
        this.year = year;
        this.month = dateFormatter.changeMonthFormat(month);
        period = this.year + "-" + this.month;
    }

    public SummaryCommand(String year) {
        this.year = year;
        period = year;
    }

    public SummaryCommand(boolean isCurrentMonth) {
        if (isCurrentMonth) {
            this.year = dateFormatter.getCurrentYear();
            this.month = dateFormatter.getCurrentMonth();
            period = year + "-" + month;
        } else {
            this.month = "-";
            period = "-";
        }
    }

    @Override
    public void execute(SpendingList spendingList, Ui ui) throws InvalidMonthException {
        if (month == null) {
            isValidMonth = false;
        }

        if (isValidMonth) {
            logger.log(Level.FINE, "going to start processing");
            double amountSpent = spendingList.getSpendingAmountTime(period);
            logger.log(Level.FINE, "end of processing");
            ui.printSummaryMessage(amountSpent);
            for (Category c : Category.values()) {
                double categoryAmountSpent = spendingList.getSpendingAmountCategory(c.toString(), period);
                ui.printSummaryCategory(c.name(), categoryAmountSpent);
            }
        } else {
            throw new InvalidMonthException();
        }
    }
}
