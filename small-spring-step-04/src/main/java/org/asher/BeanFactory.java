package org.asher;


import org.asher.support.BeansException;

/**
 * BeanFactory接口
 * @author AsherWu
 */
public interface BeanFactory {

    /**
     * 根据bean的名称获取bean对象
     * @param beanName bean的名称
     * @return bean对象
     * @throws BeansException 异常
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 根据bean的名称和参数获取bean对象
     * @param beanName bean名称
     * @param args 参数
     * @return bena对象
     * @throws BeansException 异常
     */
    Object getBean(String beanName,Object... args) throws BeansException;
}
