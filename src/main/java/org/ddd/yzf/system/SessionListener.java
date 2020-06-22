package org.ddd.yzf.system;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ddd.yzf.dto.LoginUser;
import org.ddd.yzf.util.MyTool;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        LoginUser loginUser = MyTool.cast(session.getAttribute("loginUser"));
        if (loginUser != null) {
            logger.info("{} is sign out", loginUser.getUserName());
        }
    }
}
