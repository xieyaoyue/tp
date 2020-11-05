package seedu.duke.exceptions;

//@@author killingbear999
public class InvalidInputCurrencyException extends DukeException {
    @Override
    public String toString() {
        return "Sorry, the input currency you entered is invalid. Please try again.";
    }
}
