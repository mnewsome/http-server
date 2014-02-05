package com.httpserver;

public class RedirectResponse extends ResponseGenerator{
    @Override
    public String generate(String requestURI) {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 200 OK\r\n");
        response.append("Location: http://localhost:5000/\r\n");
        return response.toString();
    }
}
