package com.httpserver;

public class MockStandardSuccessResponse {
    public String generate(String requestURI) {
        String response = "HTTP/1.1 200 OK\r\n";
        return response;
    }

}
