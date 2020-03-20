package org.javaboy.securitydy.service;

import org.javaboy.securitydy.bean.Menu;
import org.javaboy.securitydy.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Menu服务类 created by daniel in 2020/03/20
 */
@Service
public class MenuService {

    @Resource
    MenuMapper menuMapper;

    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

}
