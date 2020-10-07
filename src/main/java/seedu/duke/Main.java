package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.exceptions.InvalidStorageFilePathException;
import seedu.duke.exceptions.StorageOperationException;

public class Main {

    private static Ui ui;
    private static Storage storage;
    private static SpendingList spendingList;

    private static void run(String[] args) {
        start(args);
        runCommandLoopUntilExitCommand();
    }

    /**
     * Sets up the required objects and loads data from the storage file.
     * @param args arguments supplied by the user at program launch.
     */
    private static void start(String[] args) {
        ui = new Ui();
        try {
            storage = initializeStorage(args);
            //spendingList = storage.load();
        } catch (Exception e) {
            ui.printErrorMessage(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Reads the user command and executes it, until the user issues the 'bye' command.
     */
    private static void runCommandLoopUntilExitCommand() {
        ui.printWelcomeMessage(storage.filepath);
        boolean isExit = false;
        do {
            try {
                String fullCommand = ui.getUserInput();
                Command c = Parser.parseCommand(fullCommand);
                c.execute(spendingList, ui);
                isExit = c.isExit();
            } catch (Exception e) {
                ui.printErrorMessage(e.getMessage());
            }
        } while (!isExit);
    }

    /**
     * Creates the Storage object based on the user-specified file path (if any) or the default storage path.
     * @param args arguments supplied by the user at program launch.
     * @throws InvalidStorageFilePathException if the target file path is incorrect.
     * @throws StorageOperationException if there some error in creating storage file.
     */
    private static Storage initializeStorage(String[] args) throws InvalidStorageFilePathException,
            StorageOperationException {
        boolean isStorageFileSpecifiedByUser = args.length > 0;
        return isStorageFileSpecifiedByUser ? new Storage(args[0]) : new Storage();
    }

    public static void main(String[] args) {
        run(args);
    }
}
