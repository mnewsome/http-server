package com.httpserver;

import java.util.Date;

public class RootResponse extends ResponseGenerator{
    @Override
    public String generate(String request) {
        StringBuilder response = new StringBuilder();
        Date currentTime = new Date();
        response.append("HTTP/1.1 200 OK\r\n");
        response.append("Date: " + currentTime + "\r\n");
        response.append("Server: Newsome-HTTP-Server\r\n");
        response.append("Content-type: text/html \r\n\r\n");
        response.append("<HTML><HEAD><TITLE>You got served!</TITLE><HEAD>");
        response.append("<BODY><H1><BODY>Hello World</H1></BODY></HTML>");
        return response.toString();
    }
}