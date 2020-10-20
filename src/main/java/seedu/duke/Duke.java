package seedu.duke;

import seedu.duke.command.Command;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    private static Ui ui;
    private static Storage storage;
    private static SpendingList spendingList;

    /**
     * Runs the program until termination.
     */
    private static void run() {
        String filePath = storage.getFilePath();
        ui.printWelcomeMessage(filePath);
        boolean isExit = false;
        do {
            try {
                String fullCommand = ui.getUserInput();
                Command c = Parser.parseCommand(fullCommand);
                c.execute(spendingList, ui);
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
        try {
            storage = new Storage();
            spendingList = storage.load();
        } catch (Exception e) {
            ui.printErrorMessage(e.toString());
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}
