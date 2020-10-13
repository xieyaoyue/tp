package seedu.duke.exceptions;

public class InvalidCommandException extends DukeException {
    @Override
    public String toString() {
        return "Sorry, the command input is invalid. Please re-enter a new command.";
    }
}
