package org.ddd.yzf.chartTest;

import org.ddd.yzf.strategy.sms.config.SMSType;
import org.ddd.yzf.strategy.sms.strategy.SMSService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SMSTest {

    @Autowired
    SMSService smsService;

    @Test
    public void pinCodeTest() {
        Map<String, String> data = new HashMap<>();
        data.put("code", "1234");
        smsService.sendMsg(SMSType.VERIFICATION_CODE, "18128166132", data);

    }

}
