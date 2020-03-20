package org.javaboy.securitydy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/17 23:07
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Security";
    }

    @GetMapping("/dba/hello")
    public String dba(){
        return "hello dba";
    }

    @GetMapping("/admin/hello")
    public String admin(){
        return "hello admin";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "hello user";
    }
}
