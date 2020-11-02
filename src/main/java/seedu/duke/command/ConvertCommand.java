package seedu.duke.command;

import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.Item;
import seedu.duke.data.SpendingList;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

//@@author killingbear999
public class ConvertCommand extends Command {
    private String currencies;
    private String outputCurrency;
    private String inputCurrency;
    private Item currentString;
    private double exchangeRate = 1.0;
    public static ArrayList<Item> newSpendingList = new ArrayList<>();
    private static Logger logger = Logger.getLogger("ConvertCommand");

    /** SGD to USD; USD to SGD; SGD to CNY; CNY to SGD. */
    private final String[][] exchangeRates = {
            {"SGDUSD", "USDSGD", "SGDCNY", "CNYSGD"},
            {"0.74", "1.36", "4.99", "0.20"},
    };


    public ConvertCommand() {
    }

    public ConvertCommand(String source, String target) {
        this.inputCurrency = source;
        this.outputCurrency = target;
    }

    private String identifyCurrency() {
        return inputCurrency + outputCurrency;
    }

    private void findExchangeRate() {
        for (int i = 0; i < 4; i++) {
            if (exchangeRates[0][i].equals(currencies)) {
                exchangeRate = Double.parseDouble(exchangeRates[1][i]);
                assert exchangeRate == Double.parseDouble(exchangeRates[1][i]) : "Incorrect exchange rate";
                break;
            }
        }
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException {
        if (outputCurrency.equals("SGD") || outputCurrency.equals("USD") || outputCurrency.equals("CNY")) {
            if (inputCurrency.equals("SGD") || inputCurrency.equals("USD") || inputCurrency.equals("CNY")) {
                logger.log(Level.FINE, "going to start processing");
                newSpendingList = spendingList.getSpendingList();
                currencies = identifyCurrency();
                findExchangeRate();
                for (int i = 0; i < newSpendingList.size(); i++) {
                    currentString = newSpendingList.get(i);
                    if (!currentString.getSymbol().equals(outputCurrency)) {
                        updateNewAmount(currentString);
                        updateCurrency(currentString);
                    }
                }
                ui.printConvertCurrency(outputCurrency);
                spendingList.updateSpendingList();
                updateBudgetList();
                logger.log(Level.FINE, "end of processing");
            } else {
                ui.printInvalidInputCurrency();
            }
        } else {
            ui.printInvalidOutputCurrency();
        }
    }

    private void updateNewAmount(Item currentString) {
        double amount = currentString.getAmount();
        amount = Math.round(amount * exchangeRate * 100.0) / 100.0;
        currentString.editAmount(amount);
    }

    private void updateCurrency(Item currentString) {
        switch (currencies) {
        case "SGDUSD":
            currentString.editSymbol("USD");
            break;
        case "USDSGD":
            currentString.editSymbol("SGD");
            break;
        case "SGDCNY":
            currentString.editSymbol("CNY");
            break;
        case "CNYSGD":
            currentString.editSymbol("SGD");
            break;
        default:
        }
    }
    
    public void updateBudgetList() {
        if (!Budget.getCurrency().equals(outputCurrency)) {
            double budgetLimit = Budget.getBudgetLimit();
            double newBudgetLimit = budgetLimit * exchangeRate;
            Budget.updateBudget(outputCurrency, newBudgetLimit);
        }
    }

    public ArrayList<Item> updateSpendingList() {
        return newSpendingList;
    }
}
