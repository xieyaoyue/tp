package seedu.duke.exceptions;

public class InvalidIndexException extends IndexOutOfBoundsException {
    @Override
    public String toString() {
        return "Sorry, the index is invalid. Please re-enter the index.";
    }
}
