package seedu.duke;

import seedu.duke.exceptions.InvalidCommandException;

public class IncorrectCommand {
    private String description;
    
    public IncorrectCommand(String description) {
        this.description = description;
    }
    
    public void execute() throws InvalidCommandException {
        if (!checkValidCommand()) {
            throw new InvalidCommandException();
        }
    }
    
    public boolean checkValidCommand() {
        if (description.startsWith("convert")) {
            return true;
        } else if (description.startsWith("help")) {
            return true;
        } else if (description.startsWith("add")) {
            return true;
        } else if (description.startsWith("edit")) {
            return true;
        } else if (description.startsWith("clear")) {
            return true;
        } else if (description.startsWith("summary")) {
            return true;
        } else if (description.startsWith("logout")) {
            return true;
        }
        return false;
    }
}
