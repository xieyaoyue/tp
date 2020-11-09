package seedu.duke.command;

import seedu.duke.data.Category;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;

//@@author pinfang
public class SummaryCommand extends DateCommand {
    private final String period;
    private String currency = "SGD";
    private static final Logger logger = Logger.getLogger("SummaryCommand");

    public SummaryCommand(String year, String month) {
        if (month == null) {
            period = year;
        } else {
            period = year + "-" + month;
        }
    }

    //@author k-walter
    public SummaryCommand() {
        period = "";
    }

    @Override
    public void execute(Data data, Ui ui) {
        logger.log(Level.FINE, "going to start processing");
        if (data.spendingList.getListSize() > 0) {
            currency = data.spendingList.getItem(0).getSymbol();
        }

        double amountSpent = data.spendingList.getSpendingAmountTime(period);
        logger.log(Level.FINE, "end of processing");
        ui.printSummaryMessage(currency, amountSpent);
        for (Category c : Category.values()) {
            double categoryAmountSpent = data.spendingList.getSpendingAmountCategory(c.toString(), period);
            ui.printSummaryCategory(currency, c.name(), categoryAmountSpent);
        }
    }
}
