package org.ddd.yzf.service.permisson;

import org.ddd.yzf.dto.RequestDTO;
import org.ddd.yzf.dto.RespondDTO;
import org.ddd.yzf.entity.Permission;
import org.ddd.yzf.entity.PermissionLine;

import java.util.List;
import java.util.Map;

/**
 * @author 袁泽锋
 * @since 2019年10月5日 12:24
 * Description: TODO
 */
public interface PermissionService {

    RespondDTO<Object> addPermission(RequestDTO<PermissionLine> requestDTO);

    RespondDTO<Permission> getPermissionListData(RequestDTO<Object> requestDTO);

    Boolean delPermissionById(Long uid);

    void batchDeletion(RequestDTO<Long> requestDTO);

    RespondDTO<Object> updatePermission(RequestDTO<Permission> requestDTO);

    RespondDTO<Permission> getPermissionWithLineById(Long uid);

    /**
     * Description: 通过角色id查询所有的权限
     * Date: 2019/6/24 11:14
     * @param roleId 角色id
     * @return java.util.List<java.lang.String> 权限
     **/
    List<String> findPermissionByRoleId(Long roleId);

    /**
     * Description: 更新系统权限数据
     * @author 袁泽锋
     * @since 2019/12/4 18:11
     */
    void updateSystemPermissionData();


    /**
     * Description: 获取系统所有的api信息
     * @author 袁泽锋
     * @since 2020/6/19 15:52
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.String>>
     */
    List<Map<String, String>> getAllAPI();
}
