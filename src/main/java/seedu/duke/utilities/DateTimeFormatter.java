package seedu.duke.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateTimeFormatter {
    private String dateFormat;
    
    public DateTimeFormatter(String dateFormat) {
        this.dateFormat = dateFormat;
    }
    
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
