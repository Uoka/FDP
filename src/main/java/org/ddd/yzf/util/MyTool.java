package org.ddd.yzf.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author 袁泽锋
 * @ClassName: MyTool
 * @Description: 工具类
 * @date 2019年9月23日
 */
public abstract class MyTool {

    public static String[] chars = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    /**
	 * Description: 获取唯一8位UUID
	 * @author 袁泽锋
	 * @since 2019/12/30 4:53
	 * @return java.lang.String
	 */
    public static String getShortUuid() {
        StringBuilder stringBuffer = new StringBuilder();

        String uuid = UUID.randomUUID().toString().replace("-", "");

        for (int i = 0; i < 8; i++) {

            String str = uuid.substring(i * 4, i * 4 + 4);

            int strInteger = Integer.parseInt(str, 16);

            stringBuffer.append(chars[strInteger % 0x3E]);

        }

        return stringBuffer.toString();
    }

    /**
     * Description: 代码洁癖者专用类型转换方法
     *
     * @param obj
     * @return T
     * @author 袁泽锋
     * @since 2019/12/23 16:30
     */
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }

    /**
     * Description: 获取Ip地址
     *
     * @param request
     * @return java.lang.String
     * @author 袁泽锋
     * @since 2019/12/23 16:30
     */
    public static String getIpAddress(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if (index != -1) {
                return XFor.substring(0, index);
            } else {
                return XFor;
            }
        }
        XFor = Xip;
        if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }

    /**
     * Description: MD5加密
     *
     * @param str 待加密的字符串
     * @return java.lang.String
     * @author 袁泽锋
     * @since 2019/12/27 16:16
     */
    public static String MD5Crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();
            for (byte b : hash) {
                if ((0xff & b) < 0x10) {
                    hexString.append("0").append(Integer.toHexString((0xFF & b)));
                } else {
                    hexString.append(Integer.toHexString(0xFF & b));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }

    /**
     * Description: 判断url1是否包含了url2，即url2是否等于url1或是url1的子路径
     * @author 袁泽锋
     * @since 2020/6/19 15:47
     * @param url1
     * @param url2
     * @return boolean
     */
    public static boolean isContain(String url1, String url2) {
        if (url1 == null || url2 == null) {
            return false;
        } else {
            String[] temp1 = url1.split("/");
            String[] temp2 = url2.split("/");
            for (int i = 0; i < temp1.length; i++) {
                if(!temp1[i].equals(temp2[i])) {
                    return false;
                }
            }
            return true;
        }
    }


}
