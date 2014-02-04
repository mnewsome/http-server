package com.httpserver;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ResponseGeneratorTest {
    @Test
    public void testRootResponse() {
        Map<String, String> testResponse = new HashMap<String, String>();
        testResponse.put("200 OK", "Hello World");

        RootResponse rr = new RootResponse();
        assertEquals("Request of root returns hello world", testResponse, rr.generate("/"));
    }

//    @Test
//    public void testAuthenticationResponse() {
//        Map<String, String> testHash = new HashMap<String, String>();
//        testHash.put("401 Unauthorized", "Authentication required");
//
//        ResponseGenerator rg = new ResponseGenerator("/logs");
//        assertEquals("Authentication Required", testHash, rg.authenticationResponse());
//
//    }



}
