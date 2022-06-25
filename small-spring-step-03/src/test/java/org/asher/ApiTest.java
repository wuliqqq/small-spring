package org.asher;

import org.asher.bean.UserService;
import org.asher.config.BeanDefinition;
import org.asher.support.DefaultListableBeanFactory;
import org.junit.Test;


/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description:
 * \
 */
public class ApiTest {
    @Test
    public void testBeanFactory(){
        //1. 初始化 BeanFactory
        final DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //2. 注册bean
        final BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("userService",beanDefinition);
        //3. 第一次获取bean
        final Object bean = defaultListableBeanFactory.getBean("userService", "asherwu");
        System.out.println(bean.toString());



    }



}


