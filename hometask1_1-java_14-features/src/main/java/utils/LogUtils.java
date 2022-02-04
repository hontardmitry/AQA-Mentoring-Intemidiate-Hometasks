package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Log utils.
 */
public class LogUtils {
    /**
     * Gets logger.
     *
     * @return the logger
     */
    public static Logger getLoggerForCurrentClass() {
        final Throwable t = new Throwable();
        t.fillInStackTrace();
        final String clazz = t.getStackTrace()[1].getClassName();
        return LoggerFactory.getLogger(clazz);
    }
}
