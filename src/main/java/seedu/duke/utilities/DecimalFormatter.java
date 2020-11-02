package seedu.duke.utilities;

import java.text.DecimalFormat;

public class DecimalFormatter {
    
    public DecimalFormatter() {
    }
    
    public double convert(double amount) {
        DecimalFormat df = new DecimalFormat("0.00");
        amount = Double.valueOf(df.format(amount));
        return amount;
    }
}
