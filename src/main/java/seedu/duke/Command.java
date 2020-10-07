package seedu.duke;

public abstract class Command {
    public abstract void execute(SpendingList spendingList, Ui ui);

    public abstract boolean isExit();
}
