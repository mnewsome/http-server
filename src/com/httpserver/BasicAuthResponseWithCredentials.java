package com.httpserver;

public class BasicAuthResponseWithCredentials extends ResponseGenerator {
    @Override
    public byte[] generate(String requestURI) {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine(200) + "\r\n");
        responseBuilder.append("<HTML><BODY>GET /log HTTP/1.1</BODY></HTML>\r\n");
        responseBuilder.append("<HTML><BODY>PUT /these HTTP/1.1</BODY></HTML>\r\n");
        responseBuilder.append("<HTML><BODY>HEAD /requests HTTP/1.1</BODY></HTML>\r\n");
        byte[]response = responseBuilder.toString().getBytes();
        return response;
    }
}
