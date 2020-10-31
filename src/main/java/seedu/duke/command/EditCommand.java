package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

//@@author killingbear999
public class EditCommand extends Command {
    public String description;
    public Double amount;
    public String currency;
    public int index;
    public String category;

    public EditCommand(int index, String description, String currency, Double amount, String category) {
        this.index = index - 1;
        this.description = description;
        this.currency = currency;
        this.amount = amount;
        this.category = category;
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException {
        if (description != null) {
            spendingList.editItemDescription(index, description);
        }
        if (currency != null) {
            // TODO : edit symbol @killingbear999
        }
        if (amount != null) {
            spendingList.editItemAmount(index, amount);
        }
        if (category != null) {
            spendingList.editItemCategory(index, category);
        }
        ui.printEdit(spendingList, index);
    }
}
