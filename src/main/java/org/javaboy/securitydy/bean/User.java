package org.javaboy.securitydy.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户表实体类
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/17 20:46
 */
public class User implements Serializable, UserDetails {

    private Integer id;
    private String username;
    private String password;
    private boolean enabled;
    private boolean locked;
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //获取用户名称
    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //获取用户密码
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //账户是否可用
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //账户是否未锁定
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", locked=" + locked +
                ", roleList=" + roles +
                '}';
    }


    //账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //密码是否未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //返回用户的所有角色
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
}
