package com.codecool.codecoolquiz.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.stereotype.Component;

@Component
public class Log {

    private static Logger logger;
    private static Marker marker;

    public void logEvent(Class cls, String message) {
        initializeLogger(cls);

        if (cls.getName().contains("Handler")) {
            logger.error(marker, message);
        } else {
            logger.info(marker, message);
        }

        flushLogger();
    }

    private void initializeLogger(Class cls) {
        logger = LogManager.getLogger(cls.getName());
        marker = MarkerManager.getMarker("EVENT");
    }

    private void flushLogger() {
        logger = null;
        marker = null;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        Log.logger = logger;
    }

    public static Marker getMarker() {
        return marker;
    }

    public static void setMarker(Marker marker) {
        Log.marker = marker;
    }
}
