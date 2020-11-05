package seedu.duke.exceptions;

//@@author pinfang
public class InvalidMonthException extends DukeException {
    @Override
    public String toString() {
        return "Sorry, your month input is invalid. Please re-enter the month.";
    }
}
