package Singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setFileName("ebic.txt"); // Change file name
        logger.write("Gimulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");
        logger.close();
    }
}