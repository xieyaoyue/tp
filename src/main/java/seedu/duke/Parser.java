package seedu.duke;

import seedu.duke.command.AddCommand;
import seedu.duke.command.ClearCommand;
import seedu.duke.command.Command;
import seedu.duke.command.ConvertCommand;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.SummaryCommand;
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
        return new AddCommand(description, symbol, amount);
    }

    private Command getHelpCommand(String commandParameters) throws InvalidCommandException {
        if (commandParameters.isEmpty()) {
            return new HelpCommand();
        } else {
            throw new InvalidCommandException();
        }
    }

    private Command getClearCommand(String commandParameters) throws InvalidCommandException {
        if (commandParameters.toLowerCase().equals("all")) {
            return new ClearCommand(true, 0);
        } else {
            int clearIndex;
            try {
                clearIndex = Integer.parseInt(commandParameters);
            } catch (NumberFormatException e) {
                throw new InvalidCommandException();
            }
            return new ClearCommand(false, clearIndex);
        }
    }

    private Command getConvertCommand(String commandParameters) {
        return new ConvertCommand(commandParameters);
    }

    private Command getLogoutCommand(String commandParameters) throws InvalidCommandException {
        if (commandParameters.isEmpty()) {
            return new ExitCommand();
        } else {
            throw new InvalidCommandException();
        }
    }

    private boolean isNumeric(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private Command getSummaryCommand(String commandParameters) throws InvalidCommandException {
        if (commandParameters.isEmpty()) {
            return new SummaryCommand();
        } else {
            int dividerIndex = commandParameters.indexOf(" ");
            if (dividerIndex == -1) {
                String year = commandParameters;
                if (isNumeric(year)) {
                    return new SummaryCommand(year);
                } else {
                    throw new InvalidCommandException();
                }
            } else {
                String year = commandParameters.substring(0, dividerIndex);
                String month = commandParameters.substring(dividerIndex + 1);
                if (isNumeric(year) && isNumeric(month)) {
                    return new SummaryCommand(year, month);
                } else {
                    throw new InvalidCommandException();
                }
            }
        }
    }


    public Command getCommand(String userInput) throws InvalidCommandException {
        userInput = userInput.strip();
        String action;
        action = getAction(userInput);
        String commandParameters = userInput.substring(action.length()).strip();
        switch (action) {
        case "add": return getAddCommand(commandParameters);
        case "help": return getHelpCommand(commandParameters);
        case "clear": return getClearCommand(commandParameters);
        case "convert": return getConvertCommand(commandParameters);
        case "summary": return getSummaryCommand(commandParameters);
        case "logout": return getLogoutCommand(commandParameters);
        default: return null;
        }
    }
}
