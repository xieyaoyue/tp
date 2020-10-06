package seedu.duke.exceptions;

public class InvalidCommandException extends Exception {
    public InvalidCommandException() {
        System.out.println("Sorry, the command input is invalid. Please re-enter a new command.");
    }
}
