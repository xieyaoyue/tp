package seedu.duke.exceptions;

public class StorageOperationException extends DukeException {
    @Override
    public String toString() {
        return "Sorry, the system fails to store the information.";
    }
}
