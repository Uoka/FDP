package org.ddd.yzf.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: DBUtils
 * Description: DBUtils 类
 * Author: 袁泽锋
 * Date: 2018/11/16 16:57
 * Version: 1.0
 **/
public class DBUtils {

    private static String url;

    private static String driver;

    private static String userName;

    private static String password;

    /* 静态加载资源 */
    static {

        Properties prop = new Properties();

        BufferedInputStream buff = null;

        try {
            buff = new BufferedInputStream(DBUtils.class.getResourceAsStream("/org/ddd/yzf/config.properties"));
            prop.load(buff);
        } catch (Exception e) {
            System.out.println("======配置文件读取错误======");
            e.printStackTrace();
        } finally {
            if (null != buff) {
                try {
                    buff.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        driver = prop.getProperty("database.driver");
        url = prop.getProperty("database.url");
        userName = prop.getProperty("database.user");
        password = prop.getProperty("database.password");

    }

    /**
     * Description: 打开数据库
     * Date 2018/11/19 10:55
     * @return java.sql.Connection
     **/
    public static Connection open() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Description: 关闭数据库
     * Date: 2018/11/19 10:56
     * Param: [conn]
     **/
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
