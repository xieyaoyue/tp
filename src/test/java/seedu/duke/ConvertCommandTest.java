package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.ConvertCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertCommandTest {
    @Test
    public void identifyCurrency_SGDUSD() {
        String expectedCurrency = "SGDUSD";
        String description = "convert SGD USD";
        ConvertCommand convertCommand = new ConvertCommand(description);
        assertEquals(expectedCurrency, convertCommand.identifyCurrency(description));
    }
}
