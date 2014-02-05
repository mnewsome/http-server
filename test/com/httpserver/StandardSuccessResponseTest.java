package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardSuccessResponseTest {
    @Test
    public void testGenerate() {
        String testResponse = new MockStandardSuccessResponse().generate("/form");
        String response = new StandardSuccessResponse().generate("/form");
        assertEquals("Standard Success Response", testResponse, response);
    }


    private class MockStandardSuccessResponse {
        public String generate(String requestURI) {
            String response = "HTTP/1.1 200 OK\r\n";
            return response;
        }
    }
}
