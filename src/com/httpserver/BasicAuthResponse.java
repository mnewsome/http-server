package com.httpserver;

public class BasicAuthResponse extends ResponseGenerator {

    @Override
    public byte[] generate(String requestURI) {

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine(401));
        responseBuilder.append("Authorization: Basic YWRtaW46aHVudGVyMg==\r\n\r\n");
        responseBuilder.append("<HTML><BODY>Authentication required</BODY></HTML>\r\n");
        byte[] response = responseBuilder.toString().getBytes();
        return response;

    }
}
