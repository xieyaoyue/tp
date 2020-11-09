package seedu.duke.data;

import seedu.duke.storage.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

//@author k-walter
public class RepaymentList {
    public Storage storage;
    public ArrayList<Repay> repaymentList = new ArrayList<>();

    public RepaymentList() {
    }

    public RepaymentList(Storage storage) {
        this.storage = storage;
    }

    public ArrayList<Repay> getRepaymentList() {
        return repaymentList.stream()
            .sorted(Comparator.comparing(Repay::getDeadline))
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public void addItem(String name, String symbol, double amount, String deadline) throws IOException {
        Repay repay = new Repay(name, symbol, amount, deadline);
        repaymentList.add(repay);
        save();
    }

    public void deleteRepaymentEntry(int index) throws IOException {
        repaymentList.remove(index);
        save();
    }

    private void save() throws IOException {
        if (storage == null) {
            return;
        }
        storage.save(this);
    }

    public void clearAllEntries() throws IOException {
        repaymentList.clear();
        assert getListSize() == 0 : "list size should be 0";
        save();
    }

    public int getListSize() {
        return repaymentList.size();
    }

    public Repay getEntry(int index) {
        return repaymentList.get(index);
    }
}
