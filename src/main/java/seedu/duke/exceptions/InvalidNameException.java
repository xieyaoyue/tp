package seedu.duke.exceptions;

//@@author killingbear999
public class InvalidNameException extends DukeException {
    @Override
    public String toString() {
        return "Sorry, the name or description you input is invalid. \nName or description containing only "
                       + "alphabets will be considered valid.";
    }
}
