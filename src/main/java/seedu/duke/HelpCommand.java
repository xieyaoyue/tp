package seedu.duke;

public class HelpCommand extends Command {

    @Override
    public void execute(SpendingList spendingList, Ui ui) {
        ui.printHelp();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
