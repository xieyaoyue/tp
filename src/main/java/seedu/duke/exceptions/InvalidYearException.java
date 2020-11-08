package seedu.duke.exceptions;

public class InvalidYearException extends DukeException {
    @Override
    public String getMessage() {
        return "Sorry, your year input is invalid. Please re-enter the year.";
    }
}
