package seedu.duke.category;

public class Health extends Item {
    public Health(String description, String symbol, double amount) {
        super(description, symbol, amount);
    }

    @Override
    public String toString() {
        return "health: " + super.toString();
    }
}
