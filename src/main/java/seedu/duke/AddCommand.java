package seedu.duke;

public class AddCommand {

    private String description;
    private double amount;

    public AddCommand(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public void execute(SpendingList spendingList, Ui ui) {
        spendingList.addItem(description, amount);
        ui.printAdd(spendingList);
    }
}
