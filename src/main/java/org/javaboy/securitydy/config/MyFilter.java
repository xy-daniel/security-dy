package org.javaboy.securitydy.config;

import org.javaboy.securitydy.bean.Menu;
import org.javaboy.securitydy.bean.Role;
import org.javaboy.securitydy.service.MenuService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Security配置动态权限过滤器---->用于分析请求地址---->根据请求的地址分析出来应该具有什么权限
 */
@Component
public class MyFilter implements FilterInvocationSecurityMetadataSource {

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Resource
    MenuService menuService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //所有菜单
        List<Menu> allMenu = menuService.getAllMenu();
        for (Menu menu : allMenu) {
            //地址匹配
            if (antPathMatcher.match(menu.getPattern(), requestUrl)){
                //获取这个地址需要的角色
                List<Role> roles = menu.getRoles();
                String[] roleStr = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    roleStr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleStr);
            }
        }
        return SecurityConfig.createList("ROLE_login");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
