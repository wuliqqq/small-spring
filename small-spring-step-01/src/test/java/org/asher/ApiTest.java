package org.asher;

import org.asher.bean.UserService;
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
        //1. 初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        //2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //3. 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();
    }



}


