import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger extends Logger {
    private LogLevel level;
    private static final String FILE_NAME = "app.log";

    public FileLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == this.level;
    }

    @Override
    protected void write(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println("[File Logger] " + message);
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
}
