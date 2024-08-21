package com.zsc.hines;

import com.zsc.hines.registry.LocalRegistry;
import com.zsc.hines.server.VertxHttpServer;
import com.zsc.hines.service.UserService;

/**
 * Hello world!
 *
 */
public class ProviderMain
{
    public static void main( String[] args )
    {
        //注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        //启动web服务
        VertxHttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8085);
    }
}
