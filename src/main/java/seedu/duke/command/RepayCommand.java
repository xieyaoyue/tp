package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

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
        repaymentList = new RepaymentList(name, currency, repayment, deadline);
        repaymentList.storeCurrentString();
        ui.printRepay(repaymentList.returnCurrentString());
    }
}
