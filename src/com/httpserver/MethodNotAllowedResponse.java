package com.httpserver;

public class MethodNotAllowedResponse extends ResponseGenerator {
    @Override
    public String generate(String requestURI) {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 405 Method Not Allowed\r\n");
        return response.toString();
    }
}
