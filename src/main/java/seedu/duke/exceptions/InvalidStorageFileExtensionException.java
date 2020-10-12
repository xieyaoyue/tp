package seedu.duke.exceptions;

public class InvalidStorageFileExtensionException extends DukeException {
    @Override
    public String toString() {
        return "Please indicate a .json file";
    }
}
