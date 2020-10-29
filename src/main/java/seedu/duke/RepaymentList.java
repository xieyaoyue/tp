package seedu.duke;

import java.io.IOException;
import java.util.ArrayList;

public class RepaymentList {
    private String name;
    private String currency;
    private double repayment;
    private String deadline;
    private String currentString;

    private static Storage storage;
    public static ArrayList<String> repaymentList = new ArrayList<>();

    public RepaymentList(String name, String currency, double repayment, String deadline) {
        this.name = name;
        this.currency = currency;
        this.repayment = repayment;
        this.deadline = deadline;
    }

    public RepaymentList() {
    }

    public RepaymentList(Storage storage) {
        RepaymentList.storage = storage;
    }

    public ArrayList<String> getRepaymentList() {
        return repaymentList;
    }

    public void deleteRepaymentEntry(int index) throws IOException {
        repaymentList.remove(index);
        storage.save(this);
    }

    public void clearAllEntries() throws IOException {
        repaymentList.clear();
        storage.save(this);
    }

    public int getListSize() {
        return repaymentList.size();
    }

    public String getEntry(int index) {
        return repaymentList.get(index);
    }

    private void combine() {
        currentString = name + " " + currency + " " + repayment + " " + deadline;
    }

    public void storeCurrentString() throws IOException {
        combine();
        repaymentList.add(currentString);
        storage.save(this);
    }

    public String returnCurrentString() {
        return currentString;
    }
}
