package org.ddd.yzf.strategy.sms.config;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * ClassName: AliyunConfig
 * Description: SMS配置文件
 * Author: 袁泽锋
 * Date: 2019/9/13 14:45
 * Version: 1.0
 **/
@Component
@Validated
@ConfigurationProperties(prefix = "sms.aliyun")
public class AliyunConfig {

    @NotNull
    private String accessKeyId;
    @NotNull
    private String accessKeySecret;
    @NotNull
    private String product;
    @NotNull
    private String domain;
    @NotNull
    private String regionId;
    @NotNull
    private String signName;
    private TemplateCode templateCode;


    /**
     * Description: 获取Response
     * Date: 2019/9/16 9:37
     * @param contactTarget 联系人
     * @param data 数据
     * @param templateCode 模板
     * @return com.aliyuncs.CommonResponse
     **/
    public CommonResponse getResponse(String contactTarget, Map<String, String> data, String templateCode) throws ClientException {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(domain);
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("PhoneNumbers", contactTarget);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", JSON.toJSONString(data));
        return client.getCommonResponse(request);
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public TemplateCode getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(TemplateCode templateCode) {
        this.templateCode = templateCode;
    }

    @Validated
    public static class TemplateCode {

        @NotNull
        private String verificationCode;

        public String getVerificationCode() {
            return verificationCode;
        }

        public void setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
        }
    }

}
