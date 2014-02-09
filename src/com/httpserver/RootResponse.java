package com.httpserver;

import java.io.File;
import java.util.Date;

public class RootResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {
        StringBuilder responseBuilder = new StringBuilder();
        File directory = new File("/Users/mnewsome/cob_spec/public/");
        File[] fileListing = directory.listFiles();

        Date currentTime = new Date();
        responseBuilder.append("HTTP/1.1 200 OK\r\n");
        responseBuilder.append("Date: " + currentTime + "\r\n");
        responseBuilder.append("Server: Newsome-HTTP-Server\r\n");
        responseBuilder.append("Content-type: text/html\r\n\r\n");
        responseBuilder.append("<HTML><HEAD><TITLE>You got served!</TITLE></HEAD>");
        responseBuilder.append("<BODY><H1>Hello World</H1>");

        for (String file : directory.list()) {
            responseBuilder.append("<a href=\"/" + file + "\">" + file + "</a>\r\n");
        }

        responseBuilder.append("</BODY></HTML>");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}