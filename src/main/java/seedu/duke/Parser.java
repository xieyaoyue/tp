package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.HelpCommand;

public class Parser {
    public static Command parseCommand(String fullCommand) {
        return new HelpCommand(); //change this
    }
}
