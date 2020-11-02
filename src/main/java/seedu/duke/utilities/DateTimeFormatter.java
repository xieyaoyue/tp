package seedu.duke.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateTimeFormatter {
    private String dateFormat;
    
    public DateTimeFormatter(String dateFormat) {
        this.dateFormat = dateFormat;
    }
    
    public boolean isValid(String dateStr) {
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = formatter.format(date);
        if (dateStr.compareTo(currentDate) < 0) {
            return false;
        }
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        
        return true;
    }
}
