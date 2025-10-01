
import java.io.IOException;
import java.util.logging.*;

public final class LoggerUtil {
    private static final Logger LOGGER = Logger.getLogger("MediaPlayerSystem");
    private static boolean initialized = false;

    private LoggerUtil() {}

    public static synchronized void init() {
        if (initialized) return;
        try {
            LOGGER.setLevel(Level.ALL);
            FileHandler fh = new FileHandler("application.log", true);
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
            initialized = true;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to init logger", e);
        }
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
