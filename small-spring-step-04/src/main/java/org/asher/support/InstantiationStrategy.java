package org.asher.support;

import org.asher.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 *  实例化策略接口
 * @author asherwu
 */
public interface InstantiationStrategy {

    Object instanticate(BeanDefinition beanDefinition, String beanName, Constructor ctor,Object[] args) throws BeansException;
}
