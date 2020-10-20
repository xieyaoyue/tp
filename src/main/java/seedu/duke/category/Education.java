package seedu.duke.category;

public class Education extends Item {
    public Education(String description, String symbol, double amount) {
        super(description, symbol, amount);
    }

    @Override
    public String toString() {
        return "education: " + super.toString();
    }
}
