package seedu.duke.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import seedu.duke.command.Command;
import seedu.duke.command.SetBudgetCommand;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidFormatException;

public class SetParser extends Parser {
    public SetParser() {
        addSpendingOption(true);
    }

    @Override
    public Command parse(String[] args) throws InvalidFormatException {
        CommandLine line;
        try {
            line = parser.parse(options, args);
        } catch (ParseException e) {
            throw new InvalidFormatException();
        }

        Spending s = parseSpendingOption(line);
        return new SetBudgetCommand(s.symbol, s.amount);
    }
}
