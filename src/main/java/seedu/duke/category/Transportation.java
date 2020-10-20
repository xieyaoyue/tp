package seedu.duke.category;

public class Transportation extends Item {
    public Transportation(String description, String symbol, double amount) {
        super(description, symbol, amount);
    }

    @Override
    public String toString() {
        return "transportation: " + super.toString();
    }
}
