package com.httpserver;

public class StandardSuccessResponse extends ResponseGenerator{
    @Override
    public String generate(String requestURI) {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 200 OK\r\n");
        return response.toString();
    }
}
