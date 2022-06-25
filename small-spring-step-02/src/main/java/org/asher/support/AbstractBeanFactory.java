package org.asher.support;

import org.asher.BeanFactory;
import org.asher.config.BeanDefinition;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description: Bean工厂接口的实现抽象类
 * \
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if(bean != null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName,beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition) throws BeansException;
}

