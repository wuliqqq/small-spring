package org.asher.bean;


/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description: 用户服务层
 * \
 */
public class UserService {
    private final String name;



    public void getUserInfo(){
        System.out.println("查询到用户asherWu的信息！");
    }

    public UserService(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}

