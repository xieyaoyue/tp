package seedu.duke.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import seedu.duke.command.Command;
import seedu.duke.command.EditCommand;
import seedu.duke.exceptions.InvalidCommandException;

public class EditParser extends Parser {
    public EditParser() {
        super();
        Option description = Option.builder("d")
            .longOpt("description")
            .hasArgs()
            .argName("description")
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
            .build();

        options.addOption(description);
        options.addOption(category);
        options.addOption(spending);
    }

    @Override
    public Command parse(String[] args) throws ParseException, InvalidCommandException {
        CommandLine line = parser.parse(options, args);

        int index = getIndex(line);

        String description = null;
        if (line.hasOption("d")) {
            String[] descriptionArray = line.getOptionValues("d");
            description = String.join(" ", descriptionArray);
        }

        String category = line.getOptionValue("c");

        String symbol = null;
        Double amount = null;
        if (line.hasOption("s")) {
            String[] spending = line.getOptionValues("s");
            if (spending.length != 2) {
                throw new InvalidCommandException();
            }
            symbol = spending[0];
            amount = Double.parseDouble(spending[1]);
        }

        return new EditCommand(index, description, symbol, amount, category);
    }

}
