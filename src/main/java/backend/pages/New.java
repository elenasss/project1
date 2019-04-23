package backend.pages;

import org.apache.logging.log4j.*;

public class New {
    private static Logger logger = LogManager.getLogger(New.class.getName());

    public static void main(String[] args) {

        logger.debug("sth");
        logger.info("info");
        logger.error("error");
        logger.fatal("fatal");
    }
}
