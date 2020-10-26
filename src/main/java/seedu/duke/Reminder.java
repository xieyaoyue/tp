package seedu.duke;

import seedu.duke.command.WarnCommand;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reminder {
    private LocalDate startWeek;
    WarnCommand warn;
    private ArrayList<String> period = new ArrayList<>();

    public Reminder() {
        saveDatesToList();
        warn = new WarnCommand();
    }

    // public void execute(SpendingList spendingList, Ui ui, WarnCommand warnCommand) {
    public void execute(SpendingList spendingList, Ui ui) {
        double amountSpent = 0;
        for (String i: period) {
            amountSpent += spendingList.getSpendingAmountTime(i);
        }
        warn.execute(spendingList, ui);
        double amountRemained = warn.findRemainingAmount();
        // double amountRemained = 0;
        ui.printReminderMessage(amountSpent, amountRemained, startWeek.toString());
    }

    private LocalDate startOfWeek() {
        LocalDate today = LocalDate.now();
        DayOfWeek day = today.getDayOfWeek();
        switch (day) {
        case MONDAY:
            startWeek = today;
            break;
        case TUESDAY:
            startWeek = today.minusDays(1);
            break;
        case WEDNESDAY:
            startWeek = today.minusDays(2);
            break;
        case THURSDAY:
            startWeek = today.minusDays(3);
            break;
        case FRIDAY:
            startWeek = today.minusDays(4);
            break;
        case SATURDAY:
            startWeek = today.minusDays(5);
            break;
        case SUNDAY:
            startWeek = today.minusDays(6);
            break;
        default:
            break;
        }

        return startWeek;
    }

    private void saveDatesToList() {
        LocalDate startDay = startOfWeek();
        for (int i = 0; i < 7; i++) {
            period.add(startDay.minusDays(-i).toString());
        }
    }
}
