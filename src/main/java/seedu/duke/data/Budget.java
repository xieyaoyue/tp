package seedu.duke.data;

import java.time.LocalDate;

public class Budget {
    private static double budgetLimit;
    private static String currency = "SGD";
    public static boolean hasBudget;
    public static String date = "1000-01-01";

    public static double getBudgetLimit() {
        return budgetLimit;
    }

    public static String getCurrency() {
        return currency;
    }
    
    public static String getDate() {
        return date;
    }

    public static void addBudget(String currency, double budgetLimit) {
        Budget.currency = currency;
        Budget.budgetLimit = budgetLimit;
        Budget.hasBudget = true;
        Budget.date = currentDate();
    }

    public static void updateBudget(String outputCurrency, double newBudgetLimit) {
        Budget.currency = outputCurrency;
        Budget.budgetLimit = newBudgetLimit;
    }

    public static void clearBudget() {
        Budget.currency = "SGD";
        Budget.budgetLimit = 0;
        Budget.hasBudget = false;
    }
    
    protected static String currentDate() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }
}
