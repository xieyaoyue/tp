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
            actualCommand = (AddCommand) parser.parseCommand("add -c Food -d Item0 -s SGD 114.514");
            AddCommand expectedCommand = new AddCommand("Item0", "SGD", 114.514, "Food");
            assertEquals(expectedCommand.description, actualCommand.description);
            assertEquals(expectedCommand.symbol, actualCommand.symbol);
            assertEquals(expectedCommand.amount, actualCommand.amount);
            assertEquals(expectedCommand.category, actualCommand.category);
        } catch (Exception e) {
            assert false;
        }
    }
}