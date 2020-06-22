package org.ddd.yzf.service.test.impl;

import org.ddd.yzf.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TestServiceBean implements TestService {

    @Autowired
    private HttpServletRequest request;

    public void addSession(String str) {
        request.getSession().setAttribute("name", str);
    }

    public void removeSession() {
        request.getSession().invalidate();
    }

}
