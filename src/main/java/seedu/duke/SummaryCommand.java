package seedu.duke;

import java.time.LocalDate;

public class SummaryCommand extends Command {
    private String year;
    private String month;

    public SummaryCommand(String year, String month) {
        this.year = year;
        this.month = month;
    }

    public SummaryCommand(String year) {
        this.year = getCurrentYear();
    }

    public SummaryCommand() {
        this.month = getCurrentMonth();
    }

    @Override
    public void execute(SpendingList spendingList, Ui ui) {

    }

    @Override
    public boolean isExit() {
        return false;
    }

    private String currentDate() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }

    private String getCurrentMonth() {
        return currentDate().substring(6, 7);
    }

    private String getCurrentYear() {
        return currentDate().substring(0, 3);
    }

}
