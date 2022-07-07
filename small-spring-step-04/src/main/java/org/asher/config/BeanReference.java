package org.asher.config;

/**
 * \* @author: AsherWu
 * \* Date: 2022/6/26
 * \* Description: Bean的引用
 * \
 */
public class BeanReference {
    private final String beanName;


    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}

