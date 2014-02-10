package com.httpserver;

public class StandardSuccessResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {
        setStatus(200);
        return getStatusLine().getBytes();
    }
}
