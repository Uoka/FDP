package org.ddd.yzf.system.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {

    public static Logger logger(LogFileName fileName) {
        return LoggerFactory.getLogger(fileName.getLogFileName());
    }

}
