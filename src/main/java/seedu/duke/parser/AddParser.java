package seedu.duke.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import seedu.duke.command.AddCommand;
import seedu.duke.command.Command;
import seedu.duke.exceptions.InvalidCommandException;

public class AddParser extends Parser {
    public AddParser() {
        super();
        Option description = Option.builder("d")
            .longOpt("description")
            .hasArgs()
            .argName("description")
            .required()
            .build();
        Option category = Option.builder("c")
            .longOpt("category")
            .hasArgs()
            .argName("category")
            .build();
        Option spending = Option.builder("s")
            .longOpt("spending")
            .hasArgs()
            .argName("spending")
            .required()
            .build();

        options.addOption(description);
        options.addOption(category);
        options.addOption(spending);
    }

    @Override
    public Command parse(String[] args) throws ParseException, InvalidCommandException {
        CommandLine line = parser.parse(options, args);

        String[] descriptionArray = line.getOptionValues("d");
        String description = String.join(" ", descriptionArray);

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
