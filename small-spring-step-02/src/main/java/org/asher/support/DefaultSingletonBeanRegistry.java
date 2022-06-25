package org.asher.support;

import org.asher.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description:默认的单例bean注册的实现类
 * \
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * 单例Bean对象的容器
     */
    private Map<String,Object> singletonObjects = new HashMap<>();

    /**
     * 根据bean对象名称获取bean对象
     * @param beanName bean名称
     * @return bean对象
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 添加单例bean对象到容器中
     * @param beanName 对象名称
     * @param singletonObject 对象
     */
    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }
}

