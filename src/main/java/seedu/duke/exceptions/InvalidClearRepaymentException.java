package seedu.duke.exceptions;

//@@author xieyaoyue
public class InvalidClearRepaymentException extends DukeException {
    @Override
    public String toString() {
        return "Sorry, there's nothing to clear in the repayment list.";
    }
}
