package com.zsc.hines;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.zsc.hines.model.RpcRequest;
import com.zsc.hines.model.RpcResponse;
import com.zsc.hines.model.User;
import com.zsc.hines.serializer.JdkSerializer;
import com.zsc.hines.serializer.Serializer;
import com.zsc.hines.service.UserService;

import java.io.IOException;

/**
 * 静态代理
 */
public class UserServiceProxy implements UserService {
    @Override
    public User getUser(User user) {

        //指定序列化器
        Serializer serializer = new JdkSerializer();

        //构建请求对象
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName((UserService.class.getName()))
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();

        try {
            //将对象转换成字节码
            byte[] bodyByte = serializer.serialize(rpcRequest);
            byte[] result = null;
            //发请求
            try(HttpResponse httpResponse = HttpRequest.post("http://localhost:8085")
                    .body(bodyByte)
                    .execute()){
                result = httpResponse.bodyBytes();
            }
            //将响应的字节流转化成对象
            RpcResponse response = serializer.deserialize(result, RpcResponse.class);
            return (User) response.getData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
