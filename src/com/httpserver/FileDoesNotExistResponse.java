package com.httpserver;

public class FileDoesNotExistResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine(404));
        responseBuilder.append(getDateHeader());
        responseBuilder.append(getServerInfoHeader());
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
