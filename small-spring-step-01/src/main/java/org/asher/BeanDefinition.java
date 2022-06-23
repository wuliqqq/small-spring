package org.asher;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description: Bean的定义
 * \
 */
public class BeanDefinition {
    /**
     * bean对象
     */
    private Object bean;

    /**
     * 构造方法
     */
    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    /**
     * 获取bean的方法
     */
    public Object getBean() {
        return bean;
    }
}

