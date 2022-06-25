package org.asher.config;

/**
 * 单例注册
 * @author AsherWu
 */
public interface SingletonBeanRegistry {

    /**
     * 根据bean名称获取单例bean对象
     * @param beanName bean名称
     * @return bean对象
     */
    Object getSingleton(String beanName);
}
