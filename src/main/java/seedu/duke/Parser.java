package seedu.duke;

import seedu.duke.Command.Command;
import seedu.duke.Command.HelpCommand;

public class Parser {
    public static Command parseCommand(String fullCommand) {
        return new HelpCommand(); //change this
    }
}
