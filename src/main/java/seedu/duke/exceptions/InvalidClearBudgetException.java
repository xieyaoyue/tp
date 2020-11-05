package seedu.duke.exceptions;

public class InvalidClearBudgetException extends DukeException {
    @Override
    public String toString() {
        return "Sorry, there's no budget limit set.";
    }
}
