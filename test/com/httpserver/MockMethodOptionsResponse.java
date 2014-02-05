package com.httpserver;

public class MockMethodOptionsResponse {
    public String generate(String requestURI) {
        String response = "HTTP/1.1 200 OK\r\n" +
            "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n\r\n";
        return  response;
    }
}
