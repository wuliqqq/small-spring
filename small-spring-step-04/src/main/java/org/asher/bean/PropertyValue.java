package org.asher.bean;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/26
 * \* Description: 定义属性
 * \
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}

