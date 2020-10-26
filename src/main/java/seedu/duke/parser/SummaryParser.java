package seedu.duke.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import seedu.duke.command.Command;
import seedu.duke.command.SummaryCommand;
import seedu.duke.exceptions.InvalidCommandException;

public class SummaryParser extends Parser {
    public SummaryParser() {
        super();
        Option all = Option.builder("a")
            .longOpt("all")
            .argName("all")
            .build();

        options.addOption(all);
    }

    @Override
    public Command parse(String[] args) throws ParseException, InvalidCommandException {
        CommandLine line = parser.parse(options, args);

        if (line.hasOption("a")) {
            return new SummaryCommand();
        }

        String[] period = line.getArgs();
        if (period == null) {
            throw new InvalidCommandException();
        }

        switch (period.length) {
        case 1: return new SummaryCommand(period[0]);
        case 2: return new SummaryCommand(period[0], period[1]);
        default: throw new InvalidCommandException();
        }
    }
}
