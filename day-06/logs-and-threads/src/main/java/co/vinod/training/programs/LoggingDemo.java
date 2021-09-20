package co.vinod.training.programs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {
    private final static Logger log = LoggerFactory.getLogger(LoggingDemo.class);

    public static void main(String[] args) {

        log.trace("This is a trace message");
        log.debug("This is a debug message");
        log.info("This is a info message");
        log.warn("This is a warn message");
        log.error("This is error message");
    }
}
