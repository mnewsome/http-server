package com.httpserver;

public class PutResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {
            return getStatusLine(200).getBytes();
        }
}
