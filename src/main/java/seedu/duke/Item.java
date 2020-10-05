package seedu.duke;

import java.time.LocalDate;

public class Item {
    protected String description;
    protected double amount;

    public Item(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    protected String currentDate() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }

    public String toString() {
        return currentDate() + " " + description + " $" + amount;
    }
}
