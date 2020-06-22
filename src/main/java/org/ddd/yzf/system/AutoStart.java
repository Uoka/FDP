package org.ddd.yzf.system;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ddd.yzf.service.base.BaseService;
import org.ddd.yzf.service.permisson.PermissionService;
import org.ddd.yzf.system.permission.SystemPermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author 袁泽锋
 * @since 2019年12月4日 18:08
 * Description: 项目启动,自动执行类
 */
@Component
public class AutoStart implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger();

    private final PermissionService permissionService;

    private final BaseService baseService;

    @Autowired
    public AutoStart(PermissionService permissionService, BaseService baseService) {
        this.permissionService = permissionService;
        this.baseService = baseService;
    }

    @Override
    public void run(String... args) {
        logger.info("The system starts to initialize");

        // 获取系统接口
        SystemPermissionManager.setSystemURL(this.baseService.getAllAPI());
        logger.info("URL scan completed");

        // 获取系统权限数据
        this.permissionService.updateSystemPermissionData();
        logger.info("The system is ready");
    }

}
