package org.asher.bean;


/**
 * \* @author: AsherWu
 * \* Date: 2022/6/23
 * \* Description: 用户服务层
 * \
 */
public class UserService {
    private String uId;

    private UserDao userDao;



    public void getUserInfo(){
        System.out.println("查询到用户asherWu的信息！"+userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}

