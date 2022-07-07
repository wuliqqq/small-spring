package org.asher;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.asher.bean.UserService;
import org.asher.config.BeanDefinition;
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
        //1. 初始化 BeanFactory
        final DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //2. 注册bean
        final BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);
        //3. 第一次获取bean
        final Object bean = defaultListableBeanFactory.getBean("userService", "asherwu");
        System.out.println(bean.toString());


    }

    @Test
    public void testNewInstance() throws InstantiationException, IllegalAccessException {
        final UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Class<UserService> userServiceClass = UserService.class;
        final Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        final UserService userService = declaredConstructor.newInstance("AsherWu");
        System.out.println(userService);
    }

    @Test
    public void testParameterTypes() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        final Class<UserService> userServiceClass = UserService.class;
        final Constructor<?>[] declaredConstructors = userServiceClass.getDeclaredConstructors();
        final Constructor<?> declaredConstructor = declaredConstructors[1];
        final Constructor<UserService> declaredConstructor1 = userServiceClass.getDeclaredConstructor(declaredConstructor.getParameterTypes());
        final UserService userService = declaredConstructor1.newInstance("AsherWu");
        System.out.println(userService);

    }

    @Test
    public void testCglib(){
        final Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        final Object o = enhancer.create(new Class[]{String.class}, new Object[]{"AsherWu"});
        System.out.println(o);
    }


}


