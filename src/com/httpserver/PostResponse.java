package com.httpserver;

public class PostResponse extends ResponseGenerator {
    public byte[] generate(String requestURI) {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine(200));
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
