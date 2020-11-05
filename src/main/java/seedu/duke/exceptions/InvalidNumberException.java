package seedu.duke.exceptions;

public class InvalidNumberException extends DukeException {
    @Override
    public String toString() {
        return "Sorry, the index you input is invalid. Please try again.";
    }
}
