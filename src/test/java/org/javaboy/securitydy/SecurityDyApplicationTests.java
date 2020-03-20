package org.javaboy.securitydy;

import org.javaboy.securitydy.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityDyApplicationTests {

    @Autowired
    MenuService menuService;

    @Test
    void getAllMenu() {
        System.out.println(menuService.getAllMenu());
    }

}
