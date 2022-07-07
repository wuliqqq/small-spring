package org.asher.support;

import cn.hutool.core.bean.BeanUtil;
import org.asher.bean.PropertyValue;
import org.asher.bean.PropertyValues;
import org.asher.config.BeanDefinition;
import org.asher.config.BeanReference;

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
            // 给Bean填充属性
            applyPropertyValues(beanName,bean,beanDefinition);
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
    protected void applyPropertyValues(String beanName,Object bean,BeanDefinition beanDefinition){
        try{
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            final PropertyValue[] propertyValuesList = propertyValues.getPropertyValues();
            for (PropertyValue propertyValue : propertyValuesList) {
                final String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if(value instanceof BeanReference){
                    // A依赖B，获取B的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean,name,value);
            }

        }catch (Exception e){
            throw  new BeansException("Error setting property values:"+beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }


}

