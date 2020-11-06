package seedu.duke.command;

import seedu.duke.data.Budget;
import seedu.duke.data.RepaymentList;
import seedu.duke.data.Item;
import seedu.duke.data.SpendingList;
import seedu.duke.exceptions.EmptyListException;
import seedu.duke.exceptions.InvalidCurrencyException;
import seedu.duke.exceptions.InvalidInputCurrencyException;
import seedu.duke.exceptions.InvalidOutputCurrencyException;
import seedu.duke.ui.Ui;
import seedu.duke.utilities.DecimalFormatter;

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
            {"0.74", "1.35135", "5.00", "0.20"},
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
    
    private boolean isValid() {
        for (int i = 0; i < 4; i++) {
            if (exchangeRates[0][i].equals(currencies)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException,
            InvalidInputCurrencyException, InvalidOutputCurrencyException, InvalidCurrencyException,
            EmptyListException {
        if (outputCurrency.equals("SGD") || outputCurrency.equals("USD") || outputCurrency.equals("CNY")) {
            if (inputCurrency.equals("SGD") || inputCurrency.equals("USD") || inputCurrency.equals("CNY")) {
                convert(spendingList, ui);
            } else {
                throw new InvalidInputCurrencyException();
            }
        } else {
            throw new InvalidOutputCurrencyException();
        }
    }
    
    private void convert(SpendingList spendingList, Ui ui) throws IOException, InvalidCurrencyException,
            EmptyListException {
        int size = spendingList.getListSize();
        if (size == 0) {
            throw new EmptyListException();
        }
        String defaultCurrency = spendingList.getItem(0).getSymbol();
        if (inputCurrency.equals(defaultCurrency)) {
            logger.log(Level.FINE, "going to start processing");
            newSpendingList = spendingList.getSpendingList();
            currencies = identifyCurrency();
            findExchangeRate();
            updateList();
            if (isValid()) {
                ui.printConvertCurrency(outputCurrency);
            } else {
                throw new InvalidCurrencyException();
            }
            spendingList.updateSpendingList();
            updateBudgetList();
            logger.log(Level.FINE, "end of processing");
        } else {
            ui.printInvalidConversion(defaultCurrency);
        }
    }
    
    private void updateList() {
        for (int i = 0; i < newSpendingList.size(); i++) {
            currentString = newSpendingList.get(i);
            if (!currentString.getSymbol().equals(outputCurrency)) {
                updateNewAmount(currentString);
                updateCurrency(currentString);
            }
        }
    }
    
    private void updateNewAmount(Item currentString) {
        double amount = currentString.getAmount();
        amount = amount * exchangeRate;
        DecimalFormatter decimalFormatter = new DecimalFormatter();
        amount = decimalFormatter.convert(amount);
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
