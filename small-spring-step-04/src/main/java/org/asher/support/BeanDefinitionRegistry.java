package org.asher.support;


import org.asher.config.BeanDefinition;

/**
 * @author asherwu
 */
public interface BeanDefinitionRegistry {

    /**
     *  向注册表中注册BeanDefinition
     * @param beanName bean名称
     * @param beanDefinition bean定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
