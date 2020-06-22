package org.ddd.yzf.system.config;

import org.apache.commons.lang3.StringUtils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.util.*;

/**
 * @author 袁泽锋
 * @ClassName: Config
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2019年10月5日
 */
@Component
@PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
@ConfigurationProperties(prefix = "system")
public class SystemConfig {

    /**
     * 白名单
     */
    public static Set<String> whiteURLs;

    public static String defPath;

    public static String uploadPath;

    static {
        SystemConfig.defPath = Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("")).getPath();
    }

    public static void setWhiteURLs(Set<String> whiteURLs) {
        SystemConfig.whiteURLs = whiteURLs;
    }

    public String getWhiteURLs() {
        return whiteURLs == null ? "" : whiteURLs.toString();
    }

    public void setWhiteURLs(String whiteURLs) {
        whiteURLs = StringUtils.trimToEmpty(whiteURLs);
        String[] temp = StringUtils.split(whiteURLs, ",");
        SystemConfig.whiteURLs = new HashSet<String>(Arrays.asList(temp));
    }

    public static String getDefPath() {
        return defPath;
    }

    public static void setDefPath(String defPath) {
        if (defPath != null && !"".equals(defPath)) {
            SystemConfig.defPath = defPath;
        }
    }

    public static String getUploadPath() {
        return uploadPath;
    }

    public static void setUploadPath(String uploadPath) {
        SystemConfig.uploadPath = uploadPath;
    }
}
