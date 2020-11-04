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

    public Command parse(String[] args) throws ParseException, InvalidCommandException {
        CommandLine line = parser.parse(options, args);
        MultipleCommand mc = new MultipleCommand();

        Integer index = clearList(line, "r");
        if (index != null) {
            mc.addCommand(new ClearRepaymentListCommand(false, index));
        }
        index = clearList(line, "s");
        if (index != null) {
            mc.addCommand(new ClearSpendingListCommand(false, index));
        }
        if (line.hasOption("b")) {
            mc.addCommand(new ClearBudgetCommand());
        }
        if (mc.noCommandsGiven()) {
            throw new InvalidCommandException();
        }

        return mc;
    }

    private Integer clearList(CommandLine line, String flag) throws InvalidCommandException {
        if (!line.hasOption(flag)) {
            return null;
        }
        String indexString = line.getOptionValue(flag);
        Integer index = getIndex(indexString);
        if (index == null) {
            throw new InvalidCommandException();
        }
        return index;
    }
}
