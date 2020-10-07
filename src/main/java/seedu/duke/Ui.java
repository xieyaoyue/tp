package seedu.duke;

import java.io.PrintStream;
import java.util.Scanner;

public class Ui {
    private Scanner in;
    private PrintStream out;
    private static final String SEPARATE_LINE_CHAR = "-";
    private static final int SEPARATE_LINE_LENGTH = 40;
    private static final String LOGO = "  _____         __ _      ___              \n"
            + " / ___/__ ___  / /| | /| / (_)__ ___       \n"
            + "/ /__/ -_) _ \\/ __/ |/ |/ / (_-</ -_)      \n"
            + "\\___/\\__/_//_/\\__/|__/|__/_/___/\\__/       \n"
            + "  / _ \\___  / / /__ ____| | /| / (_)__ ___ \n"
            + " / // / _ \\/ / / _ `/ __/ |/ |/ / (_-</ -_)\n"
            + "/____/\\___/_/_/\\_,_/_/  |__/|__/_/___/\\__/ \n"
            + "                                          ";
    private static final String BORDER_CORNER = "+";
    private static final String BORDER_HORIZONTAL = "-";
    private static final String BORDER_VERTICAL = "|";
    private static final int TABLE_SIZE = 104;
    private static final String MESSAGE_HELP = "Here is a summary of the commands you can use:\n";
    private static final String MESSAGE_GOODBYE = "Goodbye!";
    private static final String[][] TABLE_OF_COMMANDS = {
            {"ACTION", "FORMAT", "EXAMPLES (IF ANY)"},
            {"add", "add -d DESCRIPTION -s SPENDING [-f SKIP CONFIRMATION]", "add -d chicken rice -s $3.00 -f"},
            {"clear", "clear INDEX", "clear 1"},
            {"", "OR clear -all", ""},
            {"convert", "convert -d DESCRIPTION -d DESCRIPTION", "convert -d SGD -d USD"},
            {"edit", "edit INDEX [-d NEW_DESCRIPTION] [-s NEW_SPENDING]", "edit 1 -d buy grocery -s $15"},
            {"help", "help", ""},
            {"list", "list", ""},
            {"", "OR list YEAR", "list 2020"},
            {"", "OR list YEAR MONTH", "list 2020 July"},
            {"", "OR list -all", ""},
            {"logout", "logout", ""},
            {"summary", "summary", ""},
            {"", "OR summary [YEAR]", "summary 2020"},
            {"", "OR summary [YEAR] [MONTH]", "summary 2020 July"},
            {"", "OR list -all", ""}
    };

    public Ui() {
        this(new Scanner(System.in), System.out);
    }

    public Ui(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    public String getUserInput() {
        return in.nextLine();
    }

    public void printMessage(String message) {
        out.println(message);
        drawSeparateLine();
    }

    public void printWelcomeMessage() {
        drawSeparateLine();
        out.println(LOGO);
        drawSeparateLine();
    }

    public void printWelcomeMessage(String filePath) {
        printWelcomeMessage();
        out.println("Local file path:");
        out.println(filePath);
        drawSeparateLine();
    }

    public void printGoodbyeMessage() {
        out.println(MESSAGE_GOODBYE);
        drawSeparateLine();
    }

    private void drawSeparateLine() {
        out.println(SEPARATE_LINE_CHAR.repeat(SEPARATE_LINE_LENGTH));
    }

    public void printSpendingList(SpendingList spendingList) {
        for (int i = 0; i < spendingList.getListSize(); i++) {
            out.println(spendingList.getItem(i));
        }
        drawSeparateLine();
    }

    private static void printTopBottomBorder() {
        System.out.println(BORDER_CORNER + BORDER_HORIZONTAL.repeat(TABLE_SIZE - 2) + BORDER_CORNER);
    }

    private static void printWithinTableBorder() {
        System.out.println(BORDER_HORIZONTAL.repeat(TABLE_SIZE));
    }

    public void printHelp() {
        out.println(MESSAGE_HELP);
        printTopBottomBorder();
        for (int i = 0; i < 16; i++) {
            System.out.format("%1s%-10s%1s%-55s%1s%-35s%1s\n", BORDER_VERTICAL, TABLE_OF_COMMANDS[i][0],
                    BORDER_VERTICAL, TABLE_OF_COMMANDS[i][1], BORDER_VERTICAL, TABLE_OF_COMMANDS[i][2],
                    BORDER_VERTICAL);
            if (i == 0 || i == 1 || i == 3 || i == 4 || i == 5 || i == 6 || i == 10 || i == 11) {
                printWithinTableBorder();
            }
        }
        printTopBottomBorder();
    }

    public void printClearIndex(Item item) {
        out.println("You've deleted the record:");
        out.print(item);
        drawSeparateLine();
    }

    public void printClearAll() {
        out.println("You've deleted all the records.");
        drawSeparateLine();
    }

    public void printAdd(SpendingList spendingList) {
        out.println("You've added the record:");
        out.println(spendingList.getItem(spendingList.getListSize() - 1));
        drawSeparateLine();
    }
}
