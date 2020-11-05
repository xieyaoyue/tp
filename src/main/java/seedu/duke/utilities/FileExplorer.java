package seedu.duke.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

//@@author Wu-Haitao
public class FileExplorer {
    String filePath;

    public FileExplorer(String filePath) {
        this.filePath = filePath;
    }

    public void openFile() throws IOException {
        File file = new File(filePath);
        Desktop.getDesktop().open(file);
    }
}
