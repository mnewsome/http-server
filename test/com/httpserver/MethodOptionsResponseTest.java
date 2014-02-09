package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MethodOptionsResponseTest {
    @Test
    public void testGenerate() {
        byte[] testResponse = new MockMethodOptionsResponse().generate("/method_options");
        byte[] response = new MethodOptionsResponse().generate("/method_options");
        assertArrayEquals(testResponse, response);
    }

    private class MockMethodOptionsResponse {
        public byte[] generate(String requestURI) {
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n\r\n";
            return response.getBytes();
        }
    }
}
