package com.httpserver;

public class RedirectResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine(301));
        responseBuilder.append("Location: http://localhost:5000/\r\n");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
