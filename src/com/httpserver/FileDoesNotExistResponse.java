package com.httpserver;

import java.util.Date;

public class FileDoesNotExistResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {
        Date currentDateTime = new Date();
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("HTTP/1.1 404 File Not Found\r\n");
        responseBuilder.append("Date: " + currentDateTime + "\r\n");
        responseBuilder.append("Server: Newsome-HTTP-Server\r\n");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
