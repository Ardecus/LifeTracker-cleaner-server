package Controller.Server;

import java.io.IOException;
import java.net.InetSocketAddress;

import Controller.ApiHandler.ApiHandler;
import com.sun.net.httpserver.HttpServer;

public class Http extends Server {
    public Http() {
        port = 8989;
    }

    public Http(int port) {
        this.port = port;
    }

    public Http(Class<? extends ApiHandler> apiClass) {
        port = 8989;
        try {
            handler = apiClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Http(int port, Class<? extends ApiHandler> apiClass) {
        this.port = port;
        try {
            handler = apiClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/api", handler);
        server.start();
        System.out.println("Server started");
    }
}
