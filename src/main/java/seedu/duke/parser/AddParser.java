package seedu.duke.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import seedu.duke.command.AddCommand;
import seedu.duke.command.Command;
import seedu.duke.exceptions.InvalidCommandException;

public class AddParser extends Parser {
    public AddParser() {
        super();
        addDescriptionOption(true);
        addCategoryOption(false);
        addSpendingOption(true);
    }

    public Command parse(String[] args) throws ParseException, InvalidCommandException {
        CommandLine line = parser.parse(options, args);

        String description = parseDescriptionOption(line);

        String category = null;
        if (line.hasOption("c")) {
            category = line.getOptionValue("c");
        }

        String[] spending = line.getOptionValues("s");
        if (spending.length != 2) {
            throw new InvalidCommandException();
        }
        String symbol = spending[0];
        double amount = Double.parseDouble(spending[1]);

        return new AddCommand(description, symbol, amount, category);
    }

}
