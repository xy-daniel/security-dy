package org.javaboy.securitydy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaboy.securitydy.bean.Role;
import org.javaboy.securitydy.bean.User;

import java.util.List;

/**
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/17 22:36
 */
@Mapper
public interface UserMapper {

    User loadUserByUsername(String username);

    List<Role> getUserRolesById(Integer id);

}
