package seedu.duke.exceptions;

public class InvalidStorageFilePathException extends Exception {
    public InvalidStorageFilePathException() {
        System.out.println("Sorry, the file path is invalid.");
    }
}
