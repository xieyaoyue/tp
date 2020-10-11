package seedu.duke;

import com.google.gson.Gson;
import seedu.duke.exceptions.InvalidStorageFileExtensionException;
import seedu.duke.exceptions.InvalidStorageFilePathException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private static File file;
    private static Gson gson;
    private static final String defaultPath = "data/duke.json";

    /**
     * Creates the Storage object based on the the default storage path.
     * @throws InvalidStorageFilePathException
     */
    public Storage() throws InvalidStorageFilePathException, InvalidStorageFileExtensionException {
        this(defaultPath);
    }

    /**
     * Creates the Storage object based on the user-specified file path
     * @param path json file path to store SpendingList
     * @throws InvalidStorageFilePathException
     */
    public Storage(String path) throws InvalidStorageFilePathException, InvalidStorageFileExtensionException {
        // Validate path
        String[] parts = path.split("\\.");
        if (path.isBlank() || parts.length == 0) {
            throw new InvalidStorageFilePathException();
        }
        String extension = parts[parts.length-1];
        if (!extension.equals("json")) {
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

    }
}
