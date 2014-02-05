package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MethodOptionsResponseTest {
    @Test
    public void testGenerate() {
        String testResponse = new MockMethodOptionsResponse().generate("/method_options");
        String response = new MethodOptionsResponse().generate("/method_options");
        assertEquals("Method options response", testResponse, response);
    }

    private class MockMethodOptionsResponse {
        public String generate(String requestURI) {
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n\r\n";
            return  response;
        }
    }
}
