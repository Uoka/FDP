package org.ddd.yzf.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ddd.yzf.entity.Permission;
import org.ddd.yzf.entity.PermissionLine;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description: TODO
 *
 * @author 袁泽锋
 * @version 1.0
 * @since 2019/12/4 18:33
 */
@Mapper
@Component
public interface PermissionDAO {

    void addPermission(Permission permission);

    List<String> findPermissionsByRoleId(@Param("roleId") Long roleId);

    List<Permission> getPermissionForPage(@Param("startIndex") Integer startIndex,
                                          @Param("pageSize") Integer pageSize,
                                          @Param("filterSql") String filterSql,
                                          @Param("sortSql") String sortSql);

    Long getTotalCountForPage(@Param("filterSql") String filterSql);

    Permission findPermissionById(@Param("uid") Long uid);

    void addPermissionLineList(List<PermissionLine> permissionLineList);

    List<PermissionLine> findLinesByPermissionId(@Param("permissionId")Long permissionId);
}
