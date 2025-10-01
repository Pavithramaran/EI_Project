public class ConsoleLogger extends Logger {
    private LogLevel level;

    public ConsoleLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == this.level;
    }

    @Override
    protected void write(String message) {
        System.out.println("[Console Logger] " + message);
    }
}
