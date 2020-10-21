package seedu.duke.category;

public class Utilities extends Item {
    public Utilities(String description, String symbol, double amount) {
        super(description, symbol, amount);
    }

    @Override
    public String toString() {
        return "utilities: " + super.toString();
    }
}
