package com.zsc.hines;

import com.zsc.hines.model.User;
import com.zsc.hines.proxy.ServiceProxyFactory;
import com.zsc.hines.service.UserService;

/**
 * Hello world!
 *
 */
public class ConsumerMain
{
    public static void main( String[] args )
    {
        //todo 通过rpc远程调用实例对象
        //使用动态代理获取对象
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("hines");

        //调用
        User newUser = userService.getUser(user);
        if(newUser != null){
            System.out.println(newUser.getName());
        }else{
            System.out.println("user == null");
        }
    }
}
