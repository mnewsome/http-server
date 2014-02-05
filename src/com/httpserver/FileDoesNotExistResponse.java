package com.httpserver;

import java.util.Date;

public class FileDoesNotExistResponse extends ResponseGenerator{
    @Override
    public String generate(String requestURI) {
        Date currentDateTime = new Date();
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 404 File Not Found\r\n");
        response.append("Date: " + currentDateTime + "\r\n");
        response.append("Server: Newsome-HTTP-Server\r\n");
        return response.toString();
    }
}
