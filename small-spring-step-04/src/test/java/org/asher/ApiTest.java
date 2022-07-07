package org.asher;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.asher.bean.PropertyValue;
import org.asher.bean.PropertyValues;
import org.asher.bean.UserDao;
import org.asher.bean.UserService;
import org.asher.config.BeanDefinition;
import org.asher.config.BeanReference;
import org.asher.support.DefaultListableBeanFactory;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description:
 * \
 */
public class ApiTest {
    @Test
    public void testBeanFactory() {
        //1. 初始化BeanFactory
        final DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //2. UserDao 注册
        defaultListableBeanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));
        //3. UserService 设置属性[uId,userDao]
        final PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","1001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        //4. userService注入Bean
        final BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        defaultListableBeanFactory.registerBeanDefinition("userService",beanDefinition);
        // UserService获取Bean
        final UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.getUserInfo();


    }




}


