package com.httpserver;

public class PostResponse extends ResponseGenerator {
    public byte[] generate(String requestURI) {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("HTTP/1.1 200 OK\r\n");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
