package org.asher.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.asher.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/25
 * \* Description:Cglib实例化方式
 * \
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instanticate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if(null == ctor){
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(),args);
    }
}

