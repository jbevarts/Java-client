package util;
import com.google.api.client.http.HttpTransport;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Logging {
    public static void enableLogging() {
        Logger logger = Logger.getLogger(HttpTransport.class.getName());
        logger.setLevel(Level.CONFIG);
        logger.addHandler(new Handler() {
            @Override
            public void close() throws SecurityException {
            }

            @Override
            public void flush() {
            }

            @Override
            public void publish(LogRecord record) {
                // Default ConsoleHandler will print >= INFO to System.err.
                if (record.getLevel().intValue() < Level.INFO.intValue()) {
                    System.out.println(record.getMessage());
                }
            }
        });
    }
}
