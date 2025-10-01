public class ErrorLogger extends Logger {
    private LogLevel level;

    public ErrorLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == this.level;
    }

    @Override
    protected void write(String message) {
        System.err.println("[Error Logger] " + message);
    }
}
