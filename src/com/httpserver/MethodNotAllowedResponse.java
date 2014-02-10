package com.httpserver;

public class MethodNotAllowedResponse extends ResponseGenerator {
    @Override
    public byte[] generate(String requestURI) {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine(405));
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
