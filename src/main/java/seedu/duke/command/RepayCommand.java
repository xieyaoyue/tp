package seedu.duke.command;

import seedu.duke.RepaymentList;
import seedu.duke.SpendingList;
import seedu.duke.Ui;

//@@author killingbear999
public class RepayCommand extends Command {

    private String description;
    private String name;
    private String currency;
    private double repayment;
    private String deadline;
    
    public RepayCommand(String description) {
        this.description = description;
    }
    
    private void identifyRepaymentInformation(String description) {
        int nameBeginIndex = description.indexOf("-d") + "-d".length() + 1;
        int nameEndIndex = description.indexOf("-s") - 1;
        name = description.substring(nameBeginIndex, nameEndIndex);
        
        int currencyBeginIndex = description.indexOf("-s") + "-s".length() + 1;
        int currencyEndIndex = currencyBeginIndex + 3;
        currency = description.substring(currencyBeginIndex, currencyEndIndex);
        
        int repaymentBeginIndex = currencyEndIndex + 1;
        int repaymentEndIndex = description.indexOf("-t") - 1;
        repayment = Double.parseDouble(description.substring(repaymentBeginIndex, repaymentEndIndex));
        
        int deadlineBeginIndex = description.indexOf("-t") + "-t".length() + 1;
        int deadlineEndIndex = description.length();
        deadline = description.substring(deadlineBeginIndex, deadlineEndIndex);
    }
    
    @Override
    public void execute(SpendingList spendingList, Ui ui) {
        identifyRepaymentInformation(description);
        RepaymentList repaymentList = new RepaymentList(name, currency, repayment, deadline);
        repaymentList.storeCurrentString();
        ui.printRepay(repaymentList.returnCurrentString());
    }
}
