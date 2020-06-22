package org.ddd.yzf.strategy.sms.strategy;

import org.ddd.yzf.strategy.sms.config.SMSType;
import org.ddd.yzf.strategy.sms.service.BaseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: SMSService
 * Description: 信息传输服务
 * Author: 袁泽锋
 * Date: 2019/5/2 9:23
 * Version: 1.0
 **/
@Component("msgService")
public class SMSService implements Serializable {

    private final Map<String, BaseMsg> SMSServiceMap = new ConcurrentHashMap<>();

    @Autowired
    public SMSService(Map<String, BaseMsg> SMSServiceMap) {
        SMSServiceMap.forEach(this.SMSServiceMap::put);
    }

    public Map<String, String> sendMsg(SMSType smsType, String contactTarget, Map<String, String> msgs){
        return this.SMSServiceMap.get(smsType.getType()).sendMsg(contactTarget, msgs);
    }

}
