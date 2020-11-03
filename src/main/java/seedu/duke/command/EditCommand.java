package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.ui.Ui;
import seedu.duke.utilities.DecimalFormatter;

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
        if (amount > 0.01) {
            if (description != null) {
                spendingList.editItemDescription(index, description);
            }
            if (amount != null) {
                DecimalFormatter decimalFormatter = new DecimalFormatter();
                amount = decimalFormatter.convert(amount);
                spendingList.editItemAmount(index, amount);
            }
            if (category != null) {
                spendingList.editItemCategory(index, category);
            }
            ui.printEdit(spendingList, index);
        } else {
            ui.printInvalidAmount();
        }
    }
}
