package com.httpserver;

public class MockMethodNotAllowed {
    public String generate(String requestURI) {
        String response = "HTTP/1.1 405 Method Not Allowed\r\n";
        return response;
    }
}
