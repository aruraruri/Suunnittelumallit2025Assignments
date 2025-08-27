package Singleton;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private FileWriter writer;

    private Logger() {
        try {
            writer = new FileWriter("log.txt");
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void write(String logEntry) {
        try {
            writer.write("\n" + logEntry);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public void setFileName(String fileName) {
        try {
            writer = new FileWriter(fileName);
        } catch (IOException error) {
            error.printStackTrace();
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
