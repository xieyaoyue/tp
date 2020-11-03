package seedu.duke.ui;

import seedu.duke.data.Item;
import seedu.duke.data.Budget;
import seedu.duke.data.Repay;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Ui {
    private Scanner in;
    private PrintStream out;
    private static final String SEPARATE_LINE_CHAR = "-";
    private static final int SEPARATE_LINE_LENGTH = 108;
    private static final String LOGO = "  _____         __ _      ___              \n"
            + " / ___/__ ___  / /| | /| / (_)__ ___       \n"
            + "/ /__/ -_) _ \\/ __/ |/ |/ / (_-</ -_)      \n"
            + "\\___/\\__/_//_/\\__/|__/|__/_/___/\\__/       \n"
            + "  / _ \\___  / / /__ ____| | /| / (_)__ ___ \n"
            + " / // / _ \\/ / / _ `/ __/ |/ |/ / (_-</ -_)\n"
            + "/____/\\___/_/_/\\_,_/_/  |__/|__/_/___/\\__/ \n";
    private static final String[][] BUDGET_QUOTES = {
            {"It takes as much energy to wish as it does to plan.", "Eleanor Roosevelt"},
            {"Just because you can afford it doesn't mean you should buy it.", "Suze Orman"},
            {"Do not save what is left after spending; instead spend what is left after saving.", "Warren Buffett"},
            {"Setting goals is the first step in turning the invisible into the visible.", "Tony Robbins"},
            {"If there is no struggle, there is no progress.", "Frederick Douglass"}
    };
    private static final String BORDER_CORNER = "+";
    private static final String BORDER_HORIZONTAL = "-";
    private static final String BORDER_VERTICAL = "|";
    private static final int TABLE_SIZE = 115;
    private static final String[][] TABLE_OF_COMMANDS = {
            {"ACTION", "FORMAT", "EXAMPLES (IF ANY)"},
            {"add", "add -c CATEGORY -d DESCRIPTION -s CURRENCY SPENDING", "add -c Food -d chicken rice -s SGD 3.00"},
            {"clear", "clear [-b] [-s SPENDING_INDEX] [-r REPAYMENT_INDEX]", "clear -s 1"},
            {"convert", "convert -s INPUT_CURRENCY -t OUTPUT_CURRENCY", "convert -s SGD -t USD"},
            {"draw", "draw [YEAR = current year] [MONTH = current month]", "draw 2020 Jun"},
            {"edit", "edit INDEX [-c NEW_CATEGORY] [-d NEW_DESCRIPTION]", "edit 1 -s SGD 4.00"},
            {"", "[-s NEW_SPENDING]", ""},
            {"export", "export PATH", "export F:\\MyFolder"},
            {"help", "help", ""},
            {"logout", "logout", ""},
            {"repay", "repay -d NAME -s CURRENCY AMOUNT -t DEADLINE", "repay -d Johnny -s SGD 5.00 -t 2020-12-02"},
            {"repayment list", "repayment list", ""},
            {"set", "set -s CURRENCY AMOUNT", "set -s SGD 100.00"},
            {"spending", "spending list [YEAR = current year]", "spending list"},
            {"list", "[MONTH = current month] [-c CATEGORY] [-a]", "OR spending list 2020 -food"},
            {"summary", "summary [YEAR = current year] [MONTH = current month]", "summary"},
            {"", "[-a]", "OR summary 2020"},
            {"purge data", "purge data", ""}
    };

    //@@author Wu-Haitao
    public Ui() {
        this(new Scanner(System.in), System.out);
    }

    //@@author Wu-Haitao
    public Ui(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    //@@author Wu-Haitao
    public String getUserInput() {
        return in.nextLine();
    }

    //@@author xieyaoyue
    public void printEncouragementMessage() {
        Random rand = new Random();
        int randInt = rand.nextInt(4);
        out.println(BUDGET_QUOTES[randInt][0]);
        out.println(" ".repeat(60) + "--" + BUDGET_QUOTES[randInt][1]);
        out.println("Keep up budgeting! You can do it!");
        drawSeparateLine();
    }

    //@@author Wu-Haitao
    public void printWelcomeMessage() {
        drawSeparateLine();
        out.println(LOGO);
        drawSeparateLine();
    }

    //@@author Wu-Haitao
    public void printWelcomeMessage(String filePath) {
        printWelcomeMessage();
        out.println("Local file path: " + filePath);
        drawSeparateLine();
    }

    //@@author Wu-Haitao
    public void printGoodbyeMessage() {
        out.println("See you next time!");
        drawSeparateLine();
    }

    //@@author Wu-Haitao
    private void drawSeparateLine() {
        out.println(SEPARATE_LINE_CHAR.repeat(SEPARATE_LINE_LENGTH));
    }

    public String getSpendingList(SpendingList spendingList) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        spendingList.getSpendingList()
                .forEach(ps::println);
        return os.toString(StandardCharsets.UTF_8);
    }

    public void printSpendingList(SpendingList spendingList) {
        if (spendingList.getListSize() == 0) {
            out.println("Nothing in the list.");
        } else {
            for (int i = 1; i < spendingList.getListSize() + 1; i++) {
                out.println(i + ". " + spendingList.getItem(i - 1));
            }
        }
        drawSeparateLine();
    }

    //@@author xieyaoyue
    private void printTopBottomBorder() {
        out.println(BORDER_CORNER + BORDER_HORIZONTAL.repeat(TABLE_SIZE - 2) + BORDER_CORNER);
    }

    //@@author xieyaoyue
    private void printWithinTableBorder() {
        System.out.println(BORDER_HORIZONTAL.repeat(TABLE_SIZE));
    }

    //@@author xieyaoyue
    public void printHelp() {
        out.println("Here is a summary of the commands you can use:");
        printTopBottomBorder();
        for (int i = 0; i < 18; i++) {
            out.format("%1s%-15s%1s%-55s%1s%-41s%1s\n", BORDER_VERTICAL, TABLE_OF_COMMANDS[i][0],
                    BORDER_VERTICAL, TABLE_OF_COMMANDS[i][1], BORDER_VERTICAL, TABLE_OF_COMMANDS[i][2],
                    BORDER_VERTICAL);
            if (i <= 4 || (i >= 6 && i <= 12) || i == 14 || i == 16) {
                printWithinTableBorder();
            }
        }
        printTopBottomBorder();
        out.println(" ");
        out.println("Note: If you see an equal sign in any of the option within the 'FORMAT' section, "
                + "this is the default parameter"
                + "\nwhich would be used even if you did not enter the parameter corresponding to the "
                + "option in your command. "
                + "\nFor example, if you enter " + '"' + "spending list" + '"' + " as a command, you "
                + "would be shown a list of spending entries of the"
                + "\ncurrent month.");
    }

    //@@author Wu-Haitao
    public void printClearIndex(Item item) {
        out.println("You've deleted the record:");
        out.println(item);
        drawSeparateLine();
    }

    //@@author Wu-Haitao
    public void printClearIndex(Repay repaymentEntry) {
        out.println("You've deleted this entry in the repayment list:");
        out.println(repaymentEntry);
        drawSeparateLine();
    }

    //@@author Wu-Haitao
    public void printClearAllSpendingList() {
        out.println("You've deleted all the records in the spending list.");
        drawSeparateLine();
    }

    //@@author xieyaoyue
    public void printClearAllRepaymentList() {
        out.println("You've deleted all the entries in the repayment list.");
        drawSeparateLine();
    }

    public void printClearBudget() {
        out.println("You've cleared your budget limit.");
        drawSeparateLine();
    }

    //@@author Wu-Haitao
    public void printAdd(SpendingList spendingList) {
        out.println("You've added the record:");
        out.println(spendingList.getItem(spendingList.getListSize() - 1));
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printAddRepay(RepaymentList repaymentList) {
        out.println("You've added this repayment record:");
        out.println(repaymentList.getEntry(repaymentList.getListSize() - 1));
        drawSeparateLine();
    }

    //@@author killingbear999
    public void printConvertCurrency(String outputCurrency) {
        out.println("The currency has been changed to " + outputCurrency + ".");
        drawSeparateLine();
    }

    //@@author killingbear999
    public void printEdit(SpendingList spendingList, int index) {
        out.println("You've updated the record:");
        out.println(spendingList.getItem(index));
        drawSeparateLine();
    }

    //@@author pinfang
    public void printSummaryMessage(double amount) {
        out.printf("You've spent $%.2f.%n", amount);
        drawSeparateLine();
    }

    public void printSummaryCategory(String category, double amount) {
        out.printf("%-20s $%.2f\n", category, amount);
    }

    //@@author Wu-Haitao
    public void printErrorMessage(String message) {
        out.println(message);
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printBudgetLimit(String currency, double budgetLimit) {
        out.println("The budget limit has been set to " + currency + " " + budgetLimit);
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printApproachingWarningMessage(String outputCurrency, double amountRemaining) {
        out.println("Warning! Your spending is approaching your budget limit.");
        out.println("You still have " + outputCurrency + " " + String.format("%.2f", amountRemaining)
                            + " remained for spending.");
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printExceedingWarningMessage() {
        out.println("Warning! Your spending has exceeded your budget limit.");
        drawSeparateLine();
    }

    //@@author xieyaoyue
    public void printPurgeData() {
        out.println("All data are deleted.");
        drawSeparateLine();
    }

    //@@author pinfang
    public void printReminderMessage(double amountSpent, double amountRemained, String startWeek) {
        out.printf("You have spent $%.2f since this Mon (%s).\n", amountSpent, startWeek);
        out.printf("You have $%.2f left in your budget.\n", amountRemained);
        drawSeparateLine();
    }

    //@@author Wu-Haitao
    public void printExportMessage() {
        out.println("The records have been exported to an Excel file successfully.");
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public static void printCurrentBudgetLimit() {
        System.out.println("The budget limit has been set to: " + Budget.getCurrency() + " " + Budget.getBudgetLimit());
        System.out.println(SEPARATE_LINE_CHAR.repeat(SEPARATE_LINE_LENGTH));
    }
    
    //@@author killingbear999
    public static void printNoBudget() {
        System.out.println("No budget has been set yet.");
        System.out.println(SEPARATE_LINE_CHAR.repeat(SEPARATE_LINE_LENGTH));
    }
    
    //@@author killingbear999
    public void printRepaymentList(ArrayList<Repay> repaymentList) {
        if (!repaymentList.isEmpty()) {
            for (int i = 1; i < repaymentList.size() + 1; i++) {
                out.println(i + ". " + repaymentList.get(i - 1));
            }
        } else {
            out.println("Nothing in the list.");
        }
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printRepay(String currentString) {
        out.println("You have added this record: ");
        out.println(currentString);
        drawSeparateLine();
    }

    //@@author Wu-Haitao
    public void printDrawMessage(boolean isSuccessful) {
        if (isSuccessful) {
            out.println("The charts have been generated successfully!");
            out.println("You can find the charts at this location:");
            out.println(System.getProperty("user.dir") + "\\Charts.xlsx");
        } else {
            out.println("Sorry, generation failed.");
        }
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printInvalidOutputCurrency() {
        out.println("Sorry, the output currency you entered is invalid. Please try again.");
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printInvalidInputCurrency() {
        out.println("Sorry, the input currency you entered is invalid. Please try again.");
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printInvalidBudget() {
        out.println("Sorry, the budget amount you entered is invalid. Please try again.");
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printInvalidAmount() {
        out.println("Sorry, the amount input is invalid. Please try again.");
        out.println("The amount input should be larger than 0.01. Negative number and extremely small amount will"
                            + "be considered as invalid input.");
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printInvalidDate() {
        out.println("Sorry, the date you input is invalid. Please try again.");
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printEmptyList() {
        out.println("Sorry, the spending list is empty.");
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printInvalidConversion(String defaultCurrency) {
        out.println("Sorry, the input currency does not match with the current currency in the spending list.");
        out.println("The current currency in the spending list is " + defaultCurrency + ".");
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printInvalidName() {
        out.println("Sorry, the name you input is invalid.");
        out.println("Name containing only alphabets will be considered valid.");
        drawSeparateLine();
    }
    
    //@@author killingbear999
    public void printInvalidCurrency() {
        out.println("Sorry, the system  only supports currency conversion for SGD to USD, or USD to SGD, "
                            + "or SGD to CNY, or CNY to SGD.");
        drawSeparateLine();
    }
}

