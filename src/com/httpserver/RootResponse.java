package com.httpserver;

import java.io.File;
import java.util.Date;

public class RootResponse extends ResponseGenerator{
    @Override
    public String generate(String requestURI) {
        StringBuilder response = new StringBuilder();

        File directory = new File(requestURI);
        File[] fileListing = directory.listFiles();

        Date currentTime = new Date();
        response.append("HTTP/1.1 200 OK\r\n");
        response.append("Date: " + currentTime + "\r\n");
        response.append("Server: Newsome-HTTP-Server\r\n");
        response.append("Content-type: text/html\r\n\r\n");
        response.append("<HTML><HEAD><TITLE>You got served!</TITLE><HEAD>");
        response.append("<BODY><H1>Hello World</H1>");

        for (File file : fileListing) {
            response.append(file.getName().toString() + " ");
        }

        response.append("</BODY></HTML>");
        return response.toString();
    }
}