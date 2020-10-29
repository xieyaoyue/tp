package seedu.duke;

import seedu.duke.command.ClearRepaymentListCommand;
import seedu.duke.command.ClearSpendingListCommand;
import seedu.duke.command.Command;
import seedu.duke.command.EncouragementCommand;
import seedu.duke.command.Reminder;
import seedu.duke.parser.Parser;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    private static Ui ui;
    private static SpendingList spendingList;
    private static RepaymentList repaymentList;
    private static Reminder reminder;
    private static EncouragementCommand encouragement;

    /**
     * Runs the program until termination.
     */
    private static void run() {
        ui.printWelcomeMessage();
        reminder.execute(spendingList, ui);
        encouragement.execute(spendingList, ui);
        boolean isExit = false;
        do {
            try {
                String fullCommand = ui.getUserInput();
                Command c = Parser.parseCommand(fullCommand);
                if (c instanceof ClearSpendingListCommand) {
                    c.execute(spendingList, ui);
                } else if (c instanceof ClearRepaymentListCommand) {
                    c.execute(repaymentList, ui);
                } else {
                    c.execute(spendingList, repaymentList, ui);
                }
                isExit = c.isExit();
            } catch (Exception e) {
                ui.printErrorMessage(e.toString());
            }
        } while (!isExit);
        ui.printGoodbyeMessage();
    }

    /**
     * Sets up the required objects and loads data from the storage file.
     */
    public Duke() {
        ui = new Ui();
        reminder = new Reminder();
        encouragement = new EncouragementCommand();
        try {
            spendingList = new Storage("data/duke_spending.json").loadSpendingList();
            repaymentList = new Storage("data/duke_repayment.json").loadRepaymentList();
        } catch (Exception e) {
            ui.printErrorMessage(e.toString());
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}
