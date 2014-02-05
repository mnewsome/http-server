package com.httpserver;

import java.util.Date;

public class MethodOptionsResponse extends ResponseGenerator {

    @Override
    public String generate(String requestURI) {
        StringBuilder response = new StringBuilder();
        Date currentTime = new Date();
        response.append("HTTP/1.1 200 OK\r\n");
        response.append("Allow: GET,HEAD,POST,OPTIONS,PUT\r\n\r\n");
        return response.toString();
    }
}
