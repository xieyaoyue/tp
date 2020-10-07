package seedu.duke;

import java.io.File;

public class Storage {
    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_FILEPATH = HOME + File.separator + "Documents"
            + File.separator + "CS2113T" + File.separator + "Spending List.txt";
    public String filepath;

    public Storage() {
        this(DEFAULT_FILEPATH);
    }

    public Storage(String filePath) {
        this.filepath = filePath;
    }
}
