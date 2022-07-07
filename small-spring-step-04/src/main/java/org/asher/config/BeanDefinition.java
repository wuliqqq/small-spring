package org.asher.config;

import org.asher.bean.PropertyValues;

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
    /**
     * 属性信息
     */
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    /**
     * 获取bean类信息
     *
     * @return
     */
    public Class getBeanClass() {
        return beanClass;
    }

    /**
     * 设置bean对象信息
     *
     * @param beanClass bean类信息
     */
    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}

