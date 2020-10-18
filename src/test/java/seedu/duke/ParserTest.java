package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.AddCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    @Test
    void parseCommand() {
        Parser parser = new Parser();
        AddCommand actualCommand;
        try {
            actualCommand = (AddCommand) parser.parseCommand("add -d Item0 -s $114.514");
            AddCommand expectedCommand = new AddCommand("Item0", "$", 114.514);
            assertEquals(expectedCommand.description, actualCommand.description);
            assertEquals(expectedCommand.symbol, actualCommand.symbol);
            assertEquals(expectedCommand.amount, actualCommand.amount);
        } catch (Exception e) {
            assert false;
        }
    }
}