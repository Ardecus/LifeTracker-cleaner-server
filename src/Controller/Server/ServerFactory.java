package Controller.Server;

import Controller.ApiHandler.ApiHandler;
import Controller.ApiHandler.NoAuthHandler;
import java.lang.reflect.Constructor;

public class ServerFactory {
    public static Server CreateServer(Class<? extends Server> serverClass, Class<? extends ApiHandler> handlerClass, int port) {
        try {
            Constructor con = serverClass.getConstructor(int.class, ApiHandler.class);
            return (Server)con.newInstance(port, handlerClass);
        } catch (Exception e) {
            return new Http(port, NoAuthHandler.class);
        }
    }
}
