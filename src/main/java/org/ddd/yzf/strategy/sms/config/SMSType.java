package org.ddd.yzf.strategy.sms.config;

public enum SMSType {

    VERIFICATION_CODE("verificationCode");

    private String type;

    SMSType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
