package seedu.duke;

import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;
import seedu.duke.command.AddCommand;
import seedu.duke.command.ClearListCommand;
import seedu.duke.command.Command;
import seedu.duke.command.ConvertCommand;
import seedu.duke.command.EditCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.SummaryCommand;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {
    static class Rule<T extends Throwable> {
        final String commandString;
        final Class<T> subclass;

        Rule(String command, Class<T> subclass) {
            this.commandString = command;
            this.subclass = subclass;
        }
    }

    static Rule[] rules = new Rule[]{
        new Rule("add -c Food -d Item 0 -s SGD 114.514", AddCommand.class),
        new Rule("add -d Item 0 -s SGD 114.514 ", AddCommand.class),
        new Rule("edit 100 -s SGD 1.23 --description Chicken Rice -c Food", EditCommand.class),
        new Rule("edit 100 -s SGD 1.23 -c Food", EditCommand.class),
        new Rule("clear --all", ClearListCommand.class),
        new Rule("clear --spending 234", ClearListCommand.class),
        new Rule("clear -r 420", ClearListCommand.class),
        new Rule("convert -s SGD --target CNY", ConvertCommand.class),
        new Rule("summary 2020 Jul", SummaryCommand.class),
        new Rule("summary --all", SummaryCommand.class),
        new Rule("help", HelpCommand.class)
    };

    @Test
    void allParserReturnClass() throws ParseException, InvalidCommandException {
        for (Rule r : rules) {
            Command c = Parser.parseCommand(r.commandString);
            assertTrue(r.subclass.isInstance(c), String.format("Expected %s, got %s", r.subclass, c.getClass()));
        }
    }

    @Test
    void addWithoutCategory() throws ParseException, InvalidCommandException {
        AddCommand c = (AddCommand) Parser.parseCommand("add -d Item 0 -s SGD 114.514 ");
        assertEquals(c.amount, 114.514);
        assertEquals(c.description, "Item 0");
        assertEquals(c.category, null);
    }

    @Test
    void addShuffledArg() throws ParseException, InvalidCommandException {
        AddCommand c = (AddCommand) Parser.parseCommand("add -d Item 0 -s SGD 114.514 -c Food ");
        assertEquals(c.amount, 114.514);
        assertEquals(c.description, "Item 0");
        assertEquals(c.category, "Food");
    }

    @Test
    void editInvalidIndex() {
        assertThrows(InvalidCommandException.class, () -> {
            EditCommand c = (EditCommand) Parser.parseCommand("edit not index -s SGD 1.23 -d Chicken Rice -c Food");
        });
    }

    @Test
    void editOneParam() throws ParseException, InvalidCommandException {
        EditCommand c = (EditCommand) Parser.parseCommand("edit 987 --description fried rice");
        assertEquals(c.index, 986);
        assertEquals(c.description, "fried rice");
        assertNull(c.amount);
        assertNull(c.symbol);
        assertNull(c.category);
    }
    /**
     * void clearIndex() throws ParseException, InvalidCommandException {
     * ClearListCommand c = (ClearListCommand) Parser.parseCommand("clear --repayment 23");
     * assertFalse(c.isClearAll);
     * assertEquals(c.clearIndex, 23);
     * }
     */

    @Test
    void convertMissingSource() {
        assertThrows(MissingOptionException.class, () -> {
            ConvertCommand c = (ConvertCommand) Parser.parseCommand("convert --target USD");
        });
    }
}