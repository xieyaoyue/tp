package seedu.duke.command;

import seedu.duke.SpendingList;
import seedu.duke.Ui;

import java.io.IOException;

public class AddCommand extends Command {

    private String description;
    private double amount;
    private String symbol;

    public AddCommand(String description, String symbol, double amount) {
        this.description = description;
        this.amount = amount;
        this.symbol = symbol;
    }

    @Override
    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        spendingList.addItem(description, symbol, amount);
        ui.printAdd(spendingList);
    }
}