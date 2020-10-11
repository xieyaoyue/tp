package seedu.duke;

import seedu.duke.command.AddCommand;
import seedu.duke.command.ClearCommand;
import seedu.duke.command.Command;
import seedu.duke.command.ConvertCommand;
import seedu.duke.command.EditCommand;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.command.SummaryCommand;
import seedu.duke.exceptions.InvalidCommandException;

public class Parser {
    private enum CommandPattern {
        HELP("^help$", "help"),
        CLEAR_ALL("^clear\\s*-all$", "clearAll"),
        CLEAR_INDEX("^clear\\s*\\d+$", "clear"),
        ADD("^add\\s*-d.+-s\\s*.\\d+(.\\d*)$", "add"),
        EDIT("^edit\\s*\\d+\\s*-d.+\\S*-s\\s*\\d+$", ""),
        LIST("^list$","list"),
        LOGOUT("^logout$", "logout"),
        CONVERT("^convert\\s*-d.+\\s*-d.+$", "convert"),
        SUMMARY("^summary$", "summary"),
        SUMMARY_YEAR("^summary\\s*\\d{4}$", "summaryYear"),
        SUMMARY_YEAR_MONTH("^summary\\s*\\d{4}\\s*[a-zA-Z]{3}$", "summaryYearMonth");

        private final String pattern;
        private final String action;
        CommandPattern(String pattern, String action) {
            this.pattern = pattern;
            this.action = action;
        }
    }

    private static String getAction(String userInput) throws InvalidCommandException {
        for (CommandPattern command: CommandPattern.values()) {
            if (userInput.matches(command.pattern)) {
                return command.action;
            }
        }
        throw new InvalidCommandException();
    }

    private static Command getAddCommand(String commandParameters) {
        int descriptionBeginIndex = commandParameters.indexOf("-d");
        int spendingBeginIndex = commandParameters.indexOf("-s");
        String description = commandParameters.substring(descriptionBeginIndex + "-d".length(),
                spendingBeginIndex).strip();
        String spending = commandParameters.substring(spendingBeginIndex + "-s".length()).strip();
        String symbol = spending.substring(0, 1);
        double amount = Double.parseDouble(spending.substring(1));
        return new AddCommand(description, symbol, amount);
    }
    
    private static Command getEditCommand(String commandParameters) {
        int descriptionBeginIndex = commandParameters.indexOf("-d");
        int spendingBeginIndex = commandParameters.indexOf("-s");
        int number = Integer.parseInt(commandParameters.substring(0, descriptionBeginIndex).strip());
        String description = commandParameters.substring(descriptionBeginIndex + "-d".length(),
                spendingBeginIndex).strip();
        String spending = commandParameters.substring(spendingBeginIndex + "-s".length()).strip();
        String symbol = spending.substring(0, 1);
        double amount = Double.parseDouble(spending.substring(1));
        return new EditCommand(number, description, symbol, amount);
    }


    public static Command parseCommand(String userInput) throws InvalidCommandException {
        userInput = userInput.strip();
        String action = getAction(userInput);
        String commandParameters = userInput.substring(action.length()).strip();
        switch (action) {
        case "add": return getAddCommand(commandParameters);
        case "help": return new HelpCommand();
        case "clear": return new ClearCommand(false, Integer.parseInt(commandParameters));
        case "clearAll": return new ClearCommand(true, 0);
        case "convert": return new ConvertCommand(commandParameters);
        case "summary": return new SummaryCommand();
        case "summaryYear": return new SummaryCommand(commandParameters);
        case "summaryYearMonth": return new SummaryCommand(commandParameters.substring(0, 4),
                commandParameters.substring(4).strip());
        case "logout": return new ExitCommand();
        case "edit": return getEditCommand(commandParameters);
        case "list": return new ListCommand();
        default: throw new InvalidCommandException();
        }
    }
}
