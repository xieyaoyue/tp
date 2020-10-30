package seedu.duke.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import seedu.duke.command.ClearRepaymentListCommand;
import seedu.duke.command.ClearSpendingListCommand;
import seedu.duke.command.Command;
import seedu.duke.exceptions.InvalidCommandException;

public class ClearParser extends Parser {
    public ClearParser() {
        super();
        Option repayment = Option.builder("r")
            .longOpt("repayment")
            .hasArg()
            .optionalArg(true)
            .argName("repayment")
            .build();
        Option spending = Option.builder("s")
            .longOpt("spending")
            .hasArg()
            .optionalArg(true)
            .argName("spending")
            .build();

        addAllOption();
        options.addOption(repayment);
        options.addOption(spending);
    }

    public Command parse(String[] args) throws ParseException, InvalidCommandException {
        CommandLine line = parser.parse(options, args);

        boolean isClearAll = parseAllOption(line);

        if (line.hasOption("r")) {
            String indexString = line.getOptionValue("r");
            Integer index = getIndex(indexString);
            if (index == null && !isClearAll) {
                throw new InvalidCommandException();
            }
            return new ClearRepaymentListCommand(isClearAll, index);
        } else if (line.hasOption("s")) {
            String indexString = line.getOptionValue("s");
            Integer index = getIndex(indexString);
            if (index == null && !isClearAll) {
                throw new InvalidCommandException();
            }
            return new ClearSpendingListCommand(isClearAll, index);
        }

        throw new InvalidCommandException();
    }
}
