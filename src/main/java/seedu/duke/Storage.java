package seedu.duke;

import com.google.gson.Gson;
import seedu.duke.exceptions.InvalidStorageFileExtensionException;
import seedu.duke.exceptions.InvalidStorageFilePathException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private static File file;
    private static Gson gson;

    /**
     * Creates the Storage object based on the user-specified file path.
     * @param path relative path to json file
     * @throws InvalidStorageFilePathException for empty or blank file path
     * @throws InvalidStorageFileExtensionException for non-json file path
     */
    public Storage(String path) throws InvalidStorageFilePathException, InvalidStorageFileExtensionException {
        // Validate path
        String[] parts = path.split("\\.");
        if (path.isBlank() || parts.length == 0) {
            throw new InvalidStorageFilePathException();
        }
        String extension = parts[parts.length - 1];
        if (parts.length == 1 || !extension.equals("json")) {
            throw new InvalidStorageFileExtensionException();
        }
        // Create or Initialise object
        file = new File(path);
        gson = new Gson();
        if (file.exists()) {
            return;
        }
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            throw new InvalidStorageFilePathException();
        }
    }

    /**
     * Exposes location of storage for Duke applications.
     * @return file path
     */
    public String getFilePath() {
        return file.getPath();
    }

    public SpendingList loadSpendingList() {
        SpendingList sl;
        try {
            Scanner s = new Scanner(file);
            String jsonContent = s
                    .useDelimiter("\\Z")
                    .next();
            sl = gson.fromJson(jsonContent, SpendingList.class);
        } catch (Exception e) {
            sl = new SpendingList(this);
        }
        return sl;
    }

    public void save(SpendingList spendingList) throws IOException {
        String jsonContent = gson.toJson(spendingList);
        FileWriter fw = new FileWriter(file, false);
        fw.write(jsonContent);
        fw.close();
    }

    public RepaymentList loadRepaymentList() {
        RepaymentList rl;
        try {
            Scanner s = new Scanner(file);
            String jsonContent = s
                .useDelimiter("\\Z")
                .next();
            rl = gson.fromJson(jsonContent, RepaymentList.class);
        } catch (Exception e) {
            rl = new RepaymentList(this);
        }
        return rl;
    }

    public void save(RepaymentList repaymentList) throws IOException {
        String jsonContent = gson.toJson(repaymentList);
        FileWriter fw = new FileWriter(file, false);
        fw.write(jsonContent);
        fw.close();
    }

}
