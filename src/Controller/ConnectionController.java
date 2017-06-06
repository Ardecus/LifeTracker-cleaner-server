package Controller;

import Controller.ApiHandler.NoAuthHandler;
import Controller.Server.Http;
import Controller.Server.Server;
import Controller.Server.ServerFactory;

public class ConnectionController {

    public static void main(String[] args) throws Exception {
        Server server = ServerFactory.CreateServer(Http.class, NoAuthHandler.class, 8989);
        server.Start();
    }
}