package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.ui.Ui;
import seedu.duke.utilities.DateTimeFormatter;
import seedu.duke.utilities.DecimalFormatter;

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
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatter("yyyy-MM-dd");
        if (repayment >= 0.01) {
            if (dateTimeFormatter.isValid(deadline)) {
                repay(repaymentList, ui);
            } else {
                ui.printInvalidDate();
            }
        } else {
            ui.printInvalidAmount();
        }
    }
    
    private void repay(RepaymentList repaymentList, Ui ui) throws IOException {
        if (isValidName()) {
            DecimalFormatter decimalFormatter = new DecimalFormatter();
            repayment = decimalFormatter.convert(repayment);
            repaymentList.addItem(name, currency, repayment, deadline);
            ui.printAddRepay(repaymentList);
        } else {
            ui.printInvalidName();
        }
    }
    
    private boolean isValidName() {
        return ((name != null) && (!name.equals("")) && (name.matches("^[a-zA-Z]*$")));
    }
}
