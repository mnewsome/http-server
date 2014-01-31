package com.httpserver;

public class ResponseGenerator {
    private final String requestURI;

    public ResponseGenerator(String requestURI) {
        this.requestURI = requestURI;
    }

    public String ResponseRouter() {
        String response = "";
        if (requestURI.contentEquals("/"))
            response = rootResponse();
        return response;
    }

    public String rootResponse() {
        return "Hello World";
    }

}
