package seedu.duke;

//@@author killingbear999
public class Repay {
    private String name;
    private double amount;
    private String symbol;
    private String deadline;
    
    public Repay(String name, String symbol, double amount, String deadline) {
        this.name = name;
        this.symbol = symbol;
        this.amount = amount;
        this.deadline = deadline;
    }
    
    public String toString() {
        return name + " " + symbol + " " + amount + " " + deadline;
    }
}

