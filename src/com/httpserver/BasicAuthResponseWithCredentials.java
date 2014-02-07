package com.httpserver;

public class BasicAuthResponseWithCredentials extends ResponseGenerator {
    @Override
    public String generate(String requestURI) {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 200 OK\r\n\r\n");
        response.append("<HTML><BODY>GET /log HTTP/1.1</BODY></HTML>\r\n");
        response.append("<HTML><BODY>PUT /these HTTP/1.1</BODY></HTML>\r\n");
        response.append("<HTML><BODY>HEAD /requests HTTP/1.1</BODY></HTML>\r\n");
        return response.toString();
    }
}
