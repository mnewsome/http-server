package com.httpserver;

import java.util.Date;

public class MockFileDoesNotExistResponse {
    public String generate (String requestURI) {
        Date currentTime = new Date();
        String response = String.format("HTTP/1.1 404 File Not Found\r\n" +
            "Date: " + currentTime + "\r\n" +
            "Server: Newsome-HTTP-Server\r\n");
        return response;
    }
}
