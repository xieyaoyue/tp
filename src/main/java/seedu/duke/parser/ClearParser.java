package seedu.duke.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import seedu.duke.command.ClearBudgetCommand;
import seedu.duke.command.ClearRepaymentListCommand;
import seedu.duke.command.ClearSpendingListCommand;
import seedu.duke.command.Command;
import seedu.duke.command.MultipleCommand;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidFormatException;
import seedu.duke.exceptions.InvalidIndexException;

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
        Option budget = Option.builder("b")
            .longOpt("budget")
            .argName("budget")
            .build();

        options.addOption(repayment);
        options.addOption(spending);
        options.addOption(budget);
    }

    public Command parse(String[] args) throws InvalidCommandException,
            InvalidFormatException, InvalidIndexException {
        CommandLine line;
        try {
            line = parser.parse(options, args);
        } catch(ParseException e) {
            throw new InvalidFormatException();
        }
        MultipleCommand mc = new MultipleCommand();

        Integer index = clearList(line, "r");
        if (index != null) {
            mc.addCommand(new ClearRepaymentListCommand(index == -1, index));
        }
        index = clearList(line, "s");
        if (index != null) {
            mc.addCommand(new ClearSpendingListCommand(index == -1, index));
        }
        if (line.hasOption("b")) {
            mc.addCommand(new ClearBudgetCommand());
        }
        if (mc.noCommandsGiven()) {
            throw new InvalidCommandException();
        }

        return mc;
    }

    /**
     * clearList parses line with flag for 0..1 argument given
     * @param line to check flags with
     * @param flag for command
     * @return null for option not selected, -1 for clear all, >=0 for clear 1
     * @throws InvalidCommandException if argument is given is invalid index
     */
    private Integer clearList(CommandLine line, String flag) throws InvalidCommandException,
            InvalidIndexException {
        if (!line.hasOption(flag)) {
            return null;
        }

        String indexString = line.getOptionValue(flag);
        boolean isClearAll = indexString == null;
        if (isClearAll) {
            return -1;
        }

        Integer index = getIndex(indexString);
        if (index == null) {
            throw new InvalidCommandException();
        }
        return index;
    }
}
