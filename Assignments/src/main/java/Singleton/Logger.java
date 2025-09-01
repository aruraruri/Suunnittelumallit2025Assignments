package Singleton;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private FileWriter writer;
    private String fileName;

    private Logger() {
        this.fileName = "log.txt";}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void write(String logEntry) {
        try {
            if (writer == null) {
                writer = new FileWriter(fileName, true); // Append mode
            }
            writer.write("\n" + logEntry);
            writer.flush(); // Ensure data is written immediately
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public void setFileName(String fileName) {
        // Only set the file name, don't create the file yet
        this.fileName = fileName;

        // If writer already exists, close it so next write will use new file
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
            writer = null; // Reset writer so it gets recreated with new file
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
