package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.InvalidMonthException;

import java.time.LocalDate;
import java.util.HashMap;

public class SummaryCommand extends Command {
    private String year;
    private String month;
    private String period;
    private boolean isValidMonth = true;

    public SummaryCommand(String year, String month) {
        this.year = year;
        this.month = changeMonthFormat(month);
        period = this.year + "-" + this.month;
    }

    public SummaryCommand(String year) {
        this.year = year;
        period = year;
    }

    public SummaryCommand() {
        this.year = getCurrentYear();
        this.month = getCurrentMonth();
        period = year + "-" + month;
    }

    @Override
    public void execute(SpendingList spendingList, Ui ui) throws InvalidMonthException {
        if (isValidMonth) {
            double amountSpent = spendingList.getSpendingAmount(period);
            ui.printSummaryMessage(amountSpent);
        } else {
            throw new InvalidMonthException();
        }
    }

    private String currentDate() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }

    private String getCurrentMonth() {
        return currentDate().substring(5, 7);
    }

    private String getCurrentYear() {
        return currentDate().substring(0, 4);
    }

    private String changeMonthFormat(String month) {
        String newFormat;
        HashMap<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        if (months.containsKey(month)) {
            newFormat = months.get(month);
        } else {
            newFormat = null;
            isValidMonth = false;
        }

        return newFormat;
    }
}
