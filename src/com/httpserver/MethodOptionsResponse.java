package com.httpserver;

import java.util.Date;

public class MethodOptionsResponse extends ResponseGenerator {

    @Override
    public byte[] generate(String requestURI) {
        StringBuilder responseBuilder = new StringBuilder();
        Date currentTime = new Date();
        responseBuilder.append("HTTP/1.1 200 OK\r\n");
        responseBuilder.append("Allow: GET,HEAD,POST,OPTIONS,PUT\r\n\r\n");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
