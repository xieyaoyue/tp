package seedu.duke.exceptions;

//@@author xieyaoyue
public class InvalidClearBudgetException extends DukeException {
    @Override
    public String getMessage() {
        return "Sorry, there's no budget limit set.";
    }
}
