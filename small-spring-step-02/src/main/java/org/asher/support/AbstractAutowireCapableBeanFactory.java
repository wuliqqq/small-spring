package org.asher.support;

import org.asher.config.BeanDefinition;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description: 实例化Bean类
 * \
 */
public  abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        }catch (InstantiationException | IllegalAccessException e){
            throw new BeansException("Instantiation of bean failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }
}

