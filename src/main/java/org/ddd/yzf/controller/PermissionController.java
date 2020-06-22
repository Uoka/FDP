package org.ddd.yzf.controller;

import org.ddd.yzf.dto.RequestDTO;
import org.ddd.yzf.dto.RespondDTO;
import org.ddd.yzf.entity.Permission;
import org.ddd.yzf.entity.PermissionLine;
import org.ddd.yzf.service.permisson.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 袁泽锋
 * @since 2019年12月30日 10:24
 * Description: TODO
 */
@RestController
@RequestMapping("/permission")
@CrossOrigin(allowCredentials = "true")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/addPermission")
    public RespondDTO<Object> addPermission(@RequestBody RequestDTO<PermissionLine> requestDTO) {
        return  this.permissionService.addPermission(requestDTO);
    }

    @GetMapping("/delPermissionById")
    public Boolean delPermissionById(@RequestParam Long uid) {
        return this.permissionService.delPermissionById(uid);
    }

    @PostMapping("/batchDeletion")
    public void batchDeletion(@RequestBody RequestDTO<Long> requestDTO) {
        this.permissionService.batchDeletion(requestDTO);
    }

    @PostMapping("/updatePermission")
    public RespondDTO<Object> updatePermission(@RequestBody RequestDTO<Permission> requestDTO) {
        return this.permissionService.updatePermission(requestDTO);
    }

    @PostMapping("/getPermissionListData")
    public RespondDTO<Permission> getPermissionListData(@RequestBody RequestDTO<Object> requestDTO) {
        return this.permissionService.getPermissionListData(requestDTO);
    }

    @GetMapping("/getPermissionWithLineById")
    public RespondDTO<Permission> getPermissionWithLineById(@RequestParam Long uid) {
        return this.permissionService.getPermissionWithLineById(uid);
    }

    @GetMapping("/getPermissionURLs")
    public List<Map<String,String>> getPermissionURLs() {
        return this.permissionService.getAllAPI();
    }
}
