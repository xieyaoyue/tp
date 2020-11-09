package seedu.duke.data;

import java.time.LocalDate;

//@@author pinfang
public class Item {
    private String description;
    private double amount;
    private String symbol;
    private String date;
    //@author k-walter
    private String category;

    //@author k-walter
    public Item(String description, String symbol, double amount) {
        this(description, symbol, amount, null);
    }

    //@author k-walter
    public Item(String description, String symbol, double amount, String category) {
        init(description, symbol, amount, category, currentDate());
    }

    //@@author k-walter
    public Item(String description, String symbol, double amount, String category, String date) {
        init(description, symbol, amount, category, date);
    }

    //@author k-walter
    protected void init(String description, String symbol, double amount, String category, String date) {
        this.description = description;
        this.symbol = symbol;
        this.amount = amount;
        this.category = Category.categoryName(category);
        this.date = date;
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

    public void editCategory(String category) {
        this.category = Category.categoryName(category);
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

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }
    
    public void editDate(String specificDate) {
        this.date = specificDate;
    }

    //@author k-walter
    @Override
    public String toString() {
        return String.format("%s [%s] %s %s %s", date, category, description, symbol, String.format("%.2f", amount));
    }
}
