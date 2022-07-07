package org.asher.support;

import org.asher.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/25
 * \* Description: JDK实例化
 * \
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instanticate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        final Class beanClass = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else{
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }

    }
}

