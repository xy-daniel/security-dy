package org.javaboy.securitydy.mapper;

import org.javaboy.securitydy.bean.Role;
import org.javaboy.securitydy.bean.User;

import java.util.List;

/**
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/17 22:36
 */
public interface UserMapper {

    User loadUserByUsername(String username);

    List<Role> getUserRolesById(Integer id);

}
