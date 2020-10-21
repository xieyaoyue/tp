package seedu.duke.category;

public class Transportation extends Item {
    protected String category;
    
    public Transportation(String description, String symbol, double amount) {
        super(description, symbol, amount);
    }

    @Override
    public String toString() {
        category = "transportation";
        return category + ": " + super.toString();
    }
}
