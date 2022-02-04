package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
    public static Logger getLoggerForCurrentClass() {
        final Throwable t = new Throwable();
        t.fillInStackTrace();
        final String clazz = t.getStackTrace()[1].getClassName();
        return LoggerFactory.getLogger(clazz);
    }
}
