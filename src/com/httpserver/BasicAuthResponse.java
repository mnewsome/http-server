package com.httpserver;

public class BasicAuthResponse extends ResponseGenerator {

    @Override
    public String generate(String requestURI) {

        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 401 Unauthorized\r\n");
        response.append("Authorization: Basic YWRtaW46aHVudGVyMg==\r\n\r\n");
        response.append("<HTML><BODY>Authentication required</BODY></HTML>\r\n");
        return response.toString();

    }
}
