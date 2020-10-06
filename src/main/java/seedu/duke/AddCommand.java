package seedu.duke;

public class AddCommand {

    private String description;
    private double amount;
    private String symbol;

    public AddCommand(String description, String symbol, double amount) {
        this.description = description;
        this.amount = amount;
        this.symbol = symbol;
    }

    public void execute(SpendingList spendingList, Ui ui) {
        spendingList.addItem(description, symbol, amount);
        ui.printAdd(spendingList);
    }
}
