package seedu.duke;

import java.util.ArrayList;

//@@author killingbear999
public class RepaymentList {
    private String name;
    private String currency;
    private double repayment;
    private String deadline;
    private String currentString;
    
    public static ArrayList<String> repaymentList = new ArrayList<>();
    
    public RepaymentList(String name, String currency, double repayment, String deadline) {
        this.name = name;
        this.currency = currency;
        this.repayment = repayment;
        this.deadline = deadline;
    }
    
    public RepaymentList() {
    }
    
    public ArrayList<String> getRepaymentList() {
        return repaymentList;
    }

    public void deleteRepaymentEntry(int index) {
        repaymentList.remove(index);
    }

    public void clearAllEntries() {
        repaymentList.clear();
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
    
    public void storeCurrentString() {
        combine();
        repaymentList.add(currentString);
    }
    
    public String returnCurrentString() {
        return currentString;
    }
}
