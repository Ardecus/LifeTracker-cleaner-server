package Controller.ApiHandler;

import Controller.MainController;
import Model.Badge;
import Service.Classes.HttpResponse;
import Service.Classes.Node;
import Service.Classes.UriTree;
import Service.Exceptions.BadRequestException;
import Service.Exceptions.UnauthorizedException;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Base64;

public class AuthHandler extends ApiHandler {
    public AuthHandler()
    {
        MainController.GetAuths();
        Badge.LoadBadges();
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        System.out.println("Request gotten for " + t.getRequestURI());
        System.out.println(t.getResponseBody());
        HttpResponse response;
        try {
            String auth = t.getRequestHeaders().getFirst("Authorisation");
            auth = Base64.getDecoder().decode(auth.getBytes()).toString();
            MainController.SetAuth(auth);
            response = parseRequest(t.getRequestURI(), t.getRequestMethod(), readBody(t));
        }
        catch (UnauthorizedException ex) {
            System.out.println("Unauthorized request");
            response = new HttpResponse(403, "Unauthorized request");
        }
        catch (Exception ex) {
            System.out.println("Failed to process request");
            response = new HttpResponse(400, "Failed to process request");
        }
        t.sendResponseHeaders(response.Code, response.Body.length());
        OutputStream os = t.getResponseBody();
        os.write(response.Body.getBytes());
        os.close();
        System.out.println("Send " + response.Body + " response");
    }

    HttpResponse parseRequest(URI uri, String method, String body) throws BadRequestException, UnauthorizedException {
        Node node = uriTree.top;
        ArrayList<String> params = new ArrayList<>();
        partparse:
        for (String str : uri.toString().split("/")) {
            if (str.isEmpty()) {
                continue partparse;
            }
            for (Node subnode : node.Subnodes) {
                if (str.equals(subnode.Name)) {
                    node = subnode;
                    continue partparse;
                }
            }
            if (node.Subnodes.size() == 0) {
                System.out.println("Too many parameters");
                throw new BadRequestException();
            }
            params.add(str);
            node = node.Subnodes.get(0);
        }

        if (params.size() > 0 && !MainController.CheckAuth(params.get(0))) {
            throw new UnauthorizedException();
        }

        params.add(body);
        String[] arrayparams = new String[params.size()];
        params.toArray(arrayparams);
        return node.Actions[UriTree.RequestMethod.get(method)].Process(arrayparams);
    }
}