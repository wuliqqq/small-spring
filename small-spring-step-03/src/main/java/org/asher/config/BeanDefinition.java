package org.asher.config;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description: bean类信息定义
 * \
 */
public class BeanDefinition {
    /**
     * bean类信息
     */
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    /**
     * 获取bean类信息
     * @return
     */
    public Class getBeanClass() {
        return beanClass;
    }

    /**
     * 设置bean对象信息
     * @param beanClass bean类信息
     */
    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}

