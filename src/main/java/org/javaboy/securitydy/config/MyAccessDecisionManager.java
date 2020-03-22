package org.javaboy.securitydy.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 判断所需要的角色我这个用户是否拥有这个角色
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/22 15:06
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //authentication---->保存了当前登录用户的信息
        //o---->FilterInvocation对象，相当于MyFilter里面的Object
        //collection---->MyFilter的返回值，保存了当前请求地址需要的权限
        for (ConfigAttribute attribute : collection) {
            if ("ROLE_login".equals(attribute.getAttribute())){
                //说明当前用户请求的地址在数据库中不存在---->即是登录之后就能访问的URL---->判断当前用户是否已经登录
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("非法请求!");
                }else{
                    return;
                }
            }
            //当前用户具备的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(attribute.getAttribute())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("非法请求!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
