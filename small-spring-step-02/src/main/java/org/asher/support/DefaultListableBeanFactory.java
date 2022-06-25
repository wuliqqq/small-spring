package org.asher.support;

import org.asher.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description: 核心类实现
 * \
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        final BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition == null){
            throw new BeansException("No bean named '"+beanName+"' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }
}

