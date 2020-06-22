package org.ddd.yzf.system.log;

public enum LogFileName {

    SERVICE("serviceLog"), CONTROLLER("controllerLog");

    private String logFileName;

    LogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }
}
