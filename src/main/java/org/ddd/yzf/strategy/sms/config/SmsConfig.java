package org.ddd.yzf.strategy.sms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: SmsConfig
 * Description: sms基础配置
 * Author: 袁泽锋
 * Date: 2019/9/15 15:45
 * Version: 1.0
 **/
@Component
@Validated
@ConfigurationProperties(prefix = "sms.regexp")
public class SmsConfig {

    private String phone;

    /**
     * 验证手机号
     * @param phone 手机号
     * @return 验证结果
     */
    public boolean isPhone(String phone) {
        if (this.phone != null && !"".endsWith(this.phone)) {
            Pattern regex = Pattern.compile(this.phone);
            Matcher matcher = regex.matcher(phone);
            return matcher.matches();
        } else {
            return true;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
