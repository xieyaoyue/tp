package seedu.duke.exceptions;

//@@author xieyaoyue
public class InvalidClearRepaymentException extends DukeException {
    @Override
    public String getMessage() {
        return "Sorry, there's nothing to clear in the repayment list.";
    }
}
