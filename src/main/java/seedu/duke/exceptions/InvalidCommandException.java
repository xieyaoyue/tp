package seedu.duke.exceptions;

//@@author killingbear999
public class InvalidCommandException extends DukeException {
    @Override
    public String toString() {
        return "Sorry, the command input is invalid. Please re-enter a new command.";
    }
}
