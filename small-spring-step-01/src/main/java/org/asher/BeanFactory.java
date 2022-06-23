package org.asher;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description: Bean工厂
 * \
 */
public class BeanFactory {

    /**
     * 所有的bean信息存储在ConcurrentHashMap容器中
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 获取bean方法
     *
     * @param beanName bean的名称
     * @return bean对象
     */
    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    /**
     * 注册Bean定义到ConcurrentHashMap容器中
     * @param beanName bean的名称
     * @param beanDefinition bean定义对象
     */
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}

