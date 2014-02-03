package com.httpserver;

import java.util.HashMap;
import java.util.Map;

public abstract class ResponseGenerator {
    public abstract Map<String, String> generate(String request);


    private final String requestURI;

    public ResponseGenerator(String requestURI) {
        this.requestURI = requestURI;
    }

    public Map<String,String> ResponseRouter() {
        Map<String,String> response = new HashMap<String, String>();
        if (requestURI.contentEquals("/"))
            response = rootResponse();
        else if (requestURI.contentEquals("/logs"))
            response = authenticationResponse();
        return response;
    }

    public Map<String, String> rootResponse() {
        Map<String, String> response = new HashMap<String, String>();
        response.put("200 OK", "Hello World");
        return response;
    }

    public Map<String, String> authenticationResponse() {
        Map<String, String> response = new HashMap<String, String>();
        response.put("401 Unauthorized", "Authentication Required");
        return response;
    }
}
