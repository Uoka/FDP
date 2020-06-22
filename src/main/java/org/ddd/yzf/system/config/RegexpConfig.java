package org.ddd.yzf.system.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 袁泽锋
 * @since 2019年12月30日 4:24
 * Description: TODO
 */
@Component
@PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
@ConfigurationProperties(prefix = "regexp-config")
public class RegexpConfig {

    @NotNull
    private Phone phone;
    @NotNull
    private Email email;

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Validated
    public static class Phone {
        @NotNull
        private String regexp;

        public boolean checkPhone(String phone) {
            if (regexp != null && !"".endsWith(regexp)) {
                Pattern regex = Pattern.compile(regexp);
                Matcher matcher = regex.matcher(phone);
                return matcher.matches();
            } else {
                return true;
            }
        }

        public String getRegexp() {
            return regexp;
        }

        public void setRegexp(String regexp) {
            this.regexp = regexp;
        }
    }

    @Validated
    public static class Email {
        @NotNull
        private String regexp;

        public boolean checkEmail(String email) {
            if (regexp != null && !"".endsWith(regexp)) {
                Pattern regex = Pattern.compile(regexp);
                Matcher matcher = regex.matcher(email);
                return matcher.matches();
            } else {
                return true;
            }
        }

        public String getRegexp() {
            return regexp;
        }

        public void setRegexp(String regexp) {
            this.regexp = regexp;
        }
    }

}
