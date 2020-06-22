package org.ddd.yzf.system.permission;

import org.ddd.yzf.util.MyTool;

import java.util.*;

/**
 * Description: 系统权限数据管理
 *
 * @author 袁泽锋
 * @version 1.0
 * @since 2019/12/4 18:21
 */
public class SystemPermissionManager {

    private static Map<Long, List<String>> rolesURLMap = new HashMap<>();

    private static List<Map<String, String>> systemURL = new ArrayList<>();

    private static long superAdministratorId = -1L;

    /**
     * Description: 判断用户的角色是否有权限访问当前路径
     *
     * @param roleIds 角色id数组
     * @param url     访问的url
     * @return boolean
     * @author 袁泽锋
     * @since 2019/12/4 18:28
     */
    public static boolean roleHasPermission(List<Long> roleIds, String url) {
        if (roleIds != null && !roleIds.isEmpty()) {
            for (Long roleId : roleIds) {
                if (Objects.equals(roleId, superAdministratorId)) {
                    return true;
                }

                // 确认该角色是否可以访问该路径
                List<String> roleURLs = rolesURLMap.get(roleId);
                if (roleURLs != null && roleURLs.size() > 0) {
                    for (String legalURL : roleURLs) {
                        if (MyTool.isContain(legalURL, url)) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    public static boolean isSuperAdministratorRole(long roleId) {
        return superAdministratorId == roleId;
    }

    public static void setRolesURLMap(Map<Long, List<String>> rolesURLMap) {
        SystemPermissionManager.rolesURLMap = rolesURLMap;
    }

    public static List<Map<String, String>> getSystemURL() {
        return systemURL;
    }

    public static void setSystemURL(List<Map<String, String>> systemURL) {
        SystemPermissionManager.systemURL = systemURL;
    }

    public static void setSuperAdministratorId(long superAdministratorId) {
        SystemPermissionManager.superAdministratorId = superAdministratorId;
    }
}

