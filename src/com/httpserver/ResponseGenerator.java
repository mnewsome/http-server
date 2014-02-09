package com.httpserver;

public abstract class ResponseGenerator {
    public abstract byte[] generate(String requestURI);
}
