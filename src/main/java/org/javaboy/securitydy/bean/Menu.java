package org.javaboy.securitydy.bean;

import java.io.Serializable;

/**
 * 权限配置列表实体类
 */
public class Menu implements Serializable {
    private Integer id;
    private String pattern;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", pattern='" + pattern + '\'' +
                '}';
    }
}
