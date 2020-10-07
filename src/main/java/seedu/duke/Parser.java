package seedu.duke;

import seedu.duke.exceptions.InvalidCommandException;


public class Parser {

    private String getAction(String userInput) throws InvalidCommandException {
        String action;
        try {
            action = userInput.substring(0, userInput.indexOf(" "));
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidCommandException();
        }
        return action;
    }

    private Command getAddCommand(String commandParameters) throws InvalidCommandException {
        commandParameters += '-';
        if (!((commandParameters.contains("-d")) && (commandParameters.contains("-s")))) {
            throw new InvalidCommandException();
        }
        int descriptionBeginIndex = commandParameters.indexOf("-d") + "-d".length();
        String description = commandParameters.substring(descriptionBeginIndex,
                commandParameters.indexOf('-', descriptionBeginIndex)).strip();
        int spendingBeginIndex = commandParameters.indexOf("-s") + "-s".length();
        String spending = commandParameters.substring(spendingBeginIndex,
                commandParameters.indexOf('-', spendingBeginIndex)).strip();
        String symbol;
        double amount;
        try {
            symbol = spending.substring(0, 1);
            amount = Double.parseDouble(spending.substring(1));
        } catch (Exception e) {
            throw new InvalidCommandException();
        }
        AddCommand newAddCommand = new AddCommand(description, symbol, amount);
        return newAddCommand;
    }

    private Command getHelpCommand(String commandParameters) throws InvalidCommandException {
        if (commandParameters.isEmpty()) {
            return new HelpCommand();
        } else {
            throw new InvalidCommandException();
        }
    }

    public Command getCommand(String userInput) throws InvalidCommandException {
        userInput = userInput.strip();
        String action;
        action = getAction(userInput);
        String commandParameters = userInput.substring(action.length());
        switch (action) {
        case "add": return getAddCommand(commandParameters);
        case "help": return getHelpCommand(commandParameters);
        default: return null;
        }
    }
}
