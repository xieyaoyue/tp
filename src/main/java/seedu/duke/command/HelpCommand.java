package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.ui.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HelpCommand extends Command {
    private static Logger logger = Logger.getLogger("HelpCommand");

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) {
        logger.log(Level.FINE, "opening up help window");
        ui.printHelp();
    }
}
