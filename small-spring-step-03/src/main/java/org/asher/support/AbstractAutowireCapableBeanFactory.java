package org.asher.support;

import org.asher.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description: 实例化Bean类
 * \
 */
public  abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition,beanName,args);
        }catch (Exception e){
            throw new BeansException("Instantiation of bean failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor = null;
        final Class<?> beanClass = beanDefinition.getBeanClass();
        final Constructor<?>[] declaredConstructor = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructor) {
            if(null != args && ctor.getParameterTypes().length == args.length){
                constructor = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instanticate(beanDefinition, beanName, constructor, args);

    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}

