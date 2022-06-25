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
     */
    Object getBean(String beanName) throws BeansException;
}
