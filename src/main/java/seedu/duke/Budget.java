package seedu.duke;

import java.util.ArrayList;

public class Budget {
    private static double budgetLimit;
    private static String currency;
    public static boolean hasBudget;

    public static double getBudgetLimit() {
        return budgetLimit;
    }

    public static String getCurrency() {
        return currency;
    }

    public static void addBudget(String currency, double budgetLimit) {
        Budget.currency = currency;
        Budget.budgetLimit = budgetLimit;
        Budget.hasBudget = true;
    }

    public static void updateBudget(String outputCurrency, double newBudgetLimit) {
        Budget.currency = outputCurrency;
        Budget.budgetLimit = newBudgetLimit;
    }

    public static void clearBudget() {
        Budget.currency = null;
        Budget.budgetLimit = 0;
        Budget.hasBudget = false;
    }
}
