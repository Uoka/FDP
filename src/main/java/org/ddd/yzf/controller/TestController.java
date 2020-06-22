package org.ddd.yzf.controller;

import com.alibaba.fastjson.JSONObject;
import org.ddd.yzf.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin(allowCredentials = "true")
public class TestController {

    private static Long studentId = 0L;


    @Autowired
    private TestService testService;


    @GetMapping("/getMessage")
    public String getMessage() {
        return "ssssssssssssss!";
    }

    @GetMapping("/sendMessage")
    public void sendMessage(@RequestParam String msg) {
        System.out.println(msg);
    }


    @GetMapping("/signIn")
    public String signIn(@RequestParam String name, HttpServletRequest request) {
        testService.addSession(name);
        return name;
    }

    @GetMapping("signOut")
    public String signOut(HttpServletRequest request) {
        testService.removeSession();
        return "退出登录";
    }

}
