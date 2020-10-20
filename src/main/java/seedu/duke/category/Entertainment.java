package seedu.duke.category;

public class Entertainment extends Item {
    public Entertainment(String description, String symbol, double amount) {
        super(description, symbol, amount);
    }

    @Override
    public String toString() {
        return "entertainment: " + super.toString();
    }
}
