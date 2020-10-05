package seedu.duke.exceptions;

public class StorageOperationException extends Exception {
    public StorageOperationException() {
        System.out.println("Sorry, the system fails to store the information.");
    }
}
