package seedu.duke.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import seedu.duke.command.AddCommand;
import seedu.duke.command.Command;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidFormatException;

public class AddParser extends Parser {
    public AddParser() {
        super();
        addDescriptionOption(true);
        addCategoryOption(false);
        addSpendingOption(true);
    }

    public Command parse(String[] args) throws InvalidFormatException {
        CommandLine line;
        try {
            line = parser.parse(options, args);
        } catch (ParseException e) {
            throw new InvalidFormatException();
        }

        String category = null;
        if (line.hasOption("c")) {
            category = line.getOptionValue("c");
        }

        String[] spending = line.getOptionValues("s");
        if (spending.length != 2) {
            throw new InvalidFormatException();
        }
        String symbol = spending[0];
        double amount;
        try {
            amount = Double.parseDouble(spending[1]);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException();
        }

        String description = parseDescriptionOption(line);

        return new AddCommand(description, symbol, amount, category);
    }

}
