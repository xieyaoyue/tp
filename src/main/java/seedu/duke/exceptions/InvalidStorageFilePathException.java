package seedu.duke.exceptions;

import seedu.duke.Duke;

public class InvalidStorageFilePathException extends DukeException {
    @Override
    public String toString() {
        return "Sorry, the file path is invalid.";
    }
}
