package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.AddCommand;
import seedu.duke.command.EditCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    @Test
    void parseCommand() {
        Parser parser = new Parser();
        AddCommand actualAddCommand;
        try {

            actualAddCommand = (AddCommand) parser.parseCommand("add -d Item0 -s $114.514");
            AddCommand expectedAddCommand = new AddCommand("Item0", "$", 114.514);
            assertEquals(expectedAddCommand.description, actualAddCommand.description);
            assertEquals(expectedAddCommand.symbol, actualAddCommand.symbol);
            assertEquals(expectedAddCommand.amount, actualAddCommand.amount);
        } catch (Exception e) {
            assert false : "Error";
        }

        EditCommand actualEditCommand;
        try {
            actualEditCommand = (EditCommand) parser.parseCommand("edit 1 -d Item0 -s $114.514");
            EditCommand expectedEditCommand = new EditCommand(1, "Item0", "$", 114.514);
            assertEquals(expectedEditCommand.index, actualEditCommand.index);
            assertEquals(expectedEditCommand.description, actualEditCommand.description);
            assertEquals(expectedEditCommand.symbol, actualEditCommand.symbol);
            assertEquals(expectedEditCommand.amount, actualEditCommand.amount);
        } catch (Exception e) {
            assert false : "Error";
        }

        assert true;
    }
}