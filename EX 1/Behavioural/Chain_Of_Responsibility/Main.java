import java.util.Scanner;

public class Main {

    private static Logger getChainOfLoggers() {
        Logger consoleLogger = new ConsoleLogger(LogLevel.INFO);
        Logger fileLogger = new FileLogger(LogLevel.DEBUG);
        Logger errorLogger = new ErrorLogger(LogLevel.ERROR);

        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(errorLogger);

        return consoleLogger; // Head of the chain
    }

    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Logging System Started. Type 'exit' to quit.");
        while (true) {
            System.out.print("Enter log level (INFO/DEBUG/ERROR): ");
            String levelInput = scanner.nextLine().trim().toUpperCase();

            if ("EXIT".equals(levelInput)) break;

            System.out.print("Enter log message: ");
            String message = scanner.nextLine();

            try {
                LogLevel level = LogLevel.valueOf(levelInput);
                loggerChain.logMessage(level, message);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid log level. Try again.");
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Logging System Terminated.");
    }
}
