package Service.Interfaces;

import Service.Classes.HttpResponse;

public interface ProcessRequest {
    HttpResponse Process(String[] params);
}
