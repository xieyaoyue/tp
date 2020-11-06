package seedu.duke.exceptions;

//@@author killingbear999
public class InvalidDateException extends DukeException {
    @Override
    public String toString() {
        return "Sorry, the date you input is invalid. Please try again.";
    }
}
