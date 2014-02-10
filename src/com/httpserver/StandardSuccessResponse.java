package com.httpserver;

public class StandardSuccessResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {
        return getStatusLine(200).getBytes();
    }
}
