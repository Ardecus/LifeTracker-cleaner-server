package Controller.Server;

import Controller.ApiHandler.ApiHandler;
import Controller.ApiHandler.NoAuthHandler;

public abstract class Server {
    protected int port;
    protected ApiHandler handler;

    public Server() {
        port = 8989;
        handler = new NoAuthHandler();
    }

    public Server(int port) {
        this.port = port;
        handler = new NoAuthHandler();
    }

    public Server(Class<? extends ApiHandler> apiClass) {
        port = 8989;
        try {
            handler = apiClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Server(int port, Class<? extends ApiHandler> apiClass) {
        this.port = port;
        try {
            handler = apiClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Start() throws Exception {}
}
