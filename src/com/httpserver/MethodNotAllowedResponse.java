package com.httpserver;

public class MethodNotAllowedResponse extends ResponseGenerator {
    @Override
    public byte[] generate(String requestURI) {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("HTTP/1.1 405 Method Not Allowed\r\n");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
