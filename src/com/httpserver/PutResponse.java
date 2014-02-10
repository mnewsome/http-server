package com.httpserver;

public class PutResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {
            String response = "HTTP/1.1 200 OK\r\n";
            return response.getBytes();
        }
}
