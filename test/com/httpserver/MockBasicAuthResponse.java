package com.httpserver;

public class MockBasicAuthResponse {
    public String generate(String requestURI) {
        String response = "HTTP/1.1 401 Unauthorized\r\n" +
                "WWW-Authenticate: Basic realm=\"logs\"\r\n\r\n" +
                "<HTML><BODY>Authentication required</BODY></HTML>";
        return response;
    }
}
