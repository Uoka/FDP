package org.ddd.yzf.system.log;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
@Aspect
public class LogAspect {

    private static Logger log = LoggerUtils.logger(LogFileName.CONTROLLER);

    @Before("within(org.ddd.yzf.controller.*)")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder stringBuffer = new StringBuilder();
        for (Object obj : args) {
            if (!(obj instanceof HttpServletRequest) && !(obj instanceof HttpServletResponse)) {
                stringBuffer.append(JSONObject.toJSONString(obj));
            }
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        log.info("接口名称：{}.{}\n\t请求参数：{}",
                method.getDeclaringClass().getName(),
                method.getName(),
                stringBuffer.toString());
    }

    @AfterReturning(value = "within(org.ddd.yzf.controller.*)", returning = "rvt")
    public void after(JoinPoint joinPoint, Object rvt) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        log.info("接口名称：{}.{}\n\t返回数据:{}",
                method.getDeclaringClass().getName(),
                method.getName(),
                JSONObject.toJSONString(rvt));
    }

}
