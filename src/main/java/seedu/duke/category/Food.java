package seedu.duke.category;

public class Food extends Item {
    public Food(String description, String symbol, double amount) {
        super(description, symbol, amount);
    }

    @Override
    public String toString() {
        return "food: " + super.toString();
    }
}
