package seedu.duke.exceptions;

//@@author xieyaoyue
public class InvalidFormatException extends DukeException {
    @Override
    public String getMessage() {
        return "Sorry, your command is in the wrong format.";
    }
}
