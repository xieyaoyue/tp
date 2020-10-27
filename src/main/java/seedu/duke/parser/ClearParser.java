package seedu.duke.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import seedu.duke.command.ClearListCommand;
import seedu.duke.command.Command;
import seedu.duke.exceptions.InvalidCommandException;

public class ClearParser extends Parser {
    public ClearParser() {
        super();
        Option all = Option.builder("a")
            .longOpt("all")
            .argName("all")
            .build();
        Option repayment = Option.builder("r")
            .longOpt("repayment")
            .hasArg()
            .argName("repayment")
            .build();
        Option spending = Option.builder("s")
            .longOpt("spending")
            .hasArg()
            .argName("spending")
            .build();

        options.addOption(all);
        options.addOption(repayment);
        options.addOption(spending);
    }

    @Override
    public Command parse(String[] args) throws ParseException, InvalidCommandException {
        CommandLine line = parser.parse(options, args);

        if (line.hasOption("a")) {
            //return new ClearListCommand(true, 1);
            return new ClearListCommand();
        }

        String indexString = null;
        if (line.hasOption("r")) {
            indexString = line.getOptionValue("r");
        } else if (line.hasOption("s")) {
            indexString = line.getOptionValue("s");
        }

        if (indexString == null) {
            throw new InvalidCommandException();
        }
        int index = getIndex(indexString);

        //return new ClearListCommand(false, index);
        return new ClearListCommand();
    }
}
