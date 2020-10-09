package seedu.duke;

import java.time.LocalDate;

public class Item {
    protected String description;
    protected double amount;
    protected String symbol;

    public Item(String description, String symbol, double amount) {
        this.description = description;
        this.symbol = symbol;
        this.amount = amount;
    }

    protected String currentDate() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }

    public void editDescription(String description) {
        this.description = description;
    }

    public void editAmount(double amount) {
        this.amount = amount;
    }

    public void editSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getYearMonth() {
        return currentDate().substring(0, 7);
    }

    public String toString() {
        return currentDate() + " " + description + " " + symbol + amount;
    }
}
