package com.httpserver;

public class BasicAuthResponse extends ResponseGenerator {

    @Override
    public String generate(String requestURI) {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 401 Unauthorized\r\n");
        response.append("WWW-Authenticate: Basic realm=\"logs\"\r\n\r\n");
        response.append("<HTML><BODY>Authentication required</BODY></HTML>\r\n");
        response.append("HTTP/1.1 200 OK\r\n");
        return response.toString();

    }
}
