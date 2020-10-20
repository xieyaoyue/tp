package seedu.duke.category;

public class Other extends Item {
    public Other(String description, String symbol, double amount) {
        super(description, symbol, amount);
    }

    @Override
    public String toString() {
        return "other: " + super.toString();
    }
}
