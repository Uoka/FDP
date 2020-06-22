package org.ddd.yzf.strategy.sms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.exceptions.ClientException;
import org.ddd.yzf.strategy.sms.config.AliyunConfig;
import org.ddd.yzf.strategy.sms.config.SmsConfig;
import org.ddd.yzf.strategy.sms.service.BaseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: VerificationCode
 * Description: VerificationCode
 * Author: 袁泽锋
 * Date: 2019/9/13 15:43
 * Version: 1.0
 **/
@Component("verificationCode")
public class VerificationCode implements BaseMsg {

    private final AliyunConfig aliyunConfig;

    private final SmsConfig smsConfig;

    @Autowired
    public VerificationCode(AliyunConfig aliyunConfig, SmsConfig smsConfig) {
        this.aliyunConfig = aliyunConfig;
        this.smsConfig = smsConfig;
    }

    @Override
    public Map<String, String> sendMsg(String contactTarget, Map<String, String> msgs) {
        Map<String, String> result = new HashMap<>();
        if (contactTarget == null || "".equals(contactTarget)) {
            /* 联系人为空 */
            result.put("Message", "CONTACT_IS_EMPTY");
            return result;
        }
        if (!smsConfig.isPhone(contactTarget)) {
            /* 联系人格式错误 */
            result.put("Message", "CONTACT_FORMAT_ERROR");
            return result;
        }
        if (msgs == null || msgs.isEmpty()) {
            /* 信息为空 */
            result.put("Message", "INFORMATION_IS_EMPTY");
            return result;
        }
        /* 发送验证码短信 */
        try {
            CommonResponse response = aliyunConfig.getResponse(contactTarget, msgs, aliyunConfig.getTemplateCode().getVerificationCode());
            JSONObject jsonObject = JSONObject.parseObject(response.getData());
            if ("OK".equals(jsonObject.getString("Code"))) {
                result.put("Message", "OK");
            } else {
                /* 发送失败 */
                result.put("Message", jsonObject.getString("Code"));
            }
        } catch (ClientException e) {
            /* 发送出错 */
            e.printStackTrace();
            result.put("Message", e.toString());
        }
        return result;
    }

}
