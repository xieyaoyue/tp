package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.ui.Ui;
import seedu.duke.utilities.DateTimeFormatter;

import java.io.IOException;

//@@author killingbear999
public class RepayCommand extends Command {
    private String name;
    private String currency;
    private double repayment;
    private String deadline;

    public RepayCommand(String name, String currency, Double amount, String deadline) {
        this.name = name;
        this.currency = currency;
        this.repayment = amount;
        this.deadline = deadline;
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException {
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatter("yyyy-mm-dd");
        if (repayment >= 0) {
            if (dateTimeFormatter.isValid(deadline)) {
                repaymentList.addItem(name, currency, repayment, deadline);
                ui.printAddRepay(repaymentList);
            } else {
                ui.printInvalidDate();
            }
        } else {
            ui.printInvalidAmount();
        }
    }
}
