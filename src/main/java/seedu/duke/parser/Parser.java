package seedu.duke.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import seedu.duke.command.RepaymentListCommand;
import seedu.duke.command.Command;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.ViewCommand;
import seedu.duke.command.ExitCommand;
import seedu.duke.exceptions.InvalidCommandException;

import java.util.Arrays;

public abstract class Parser {
    protected static CommandLineParser parser;
    protected static Options options;

    public abstract Command parse(String[] args) throws ParseException, InvalidCommandException;

    public Parser() {
        parser = new DefaultParser();
        options = new Options();
    }

    protected static int getIndex(CommandLine line) throws InvalidCommandException {
        String[] indexString = line.getArgs();
        if (indexString.length != 1) {
            throw new InvalidCommandException();
        }
        return getIndex(indexString[0]);
    }

    protected static int getIndex(String s) {
        int index = Integer.parseInt(s);
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return index;
    }

    public static Command parseCommand(String userInput) throws InvalidCommandException, ParseException {
        String[] args = userInput.strip().split(" ");
        if (args.length == 0) {
            throw new InvalidCommandException();
        }

        String cmd = args[0];
        String[] opts = Arrays.copyOfRange(args, 1, args.length);

        switch (cmd) {
        case "add": return new AddParser().parse(opts);
        case "edit": return new EditParser().parse(opts);
        case "help": return new HelpCommand();
        case "clear": return new ClearParser().parse(opts);
        case "convert": return new ConvertParser().parse(opts);
        case "draw":
        case "export":
        case "repay":
        case "repayment":
            return new RepaymentListCommand();
        case "set":
        case "spending":
            return null;
        case "logout": return new ExitCommand();
        case "summary": return new SummaryParser().parse(opts);
        case "view": return new ViewCommand();
        default: throw new InvalidCommandException();
        }
    }
}
