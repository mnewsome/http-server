package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MethodNotAllowedResponseTest {
    @Test
    public void testGenerate() {
        byte[] testResponse = new MockMethodNotAllowed().generate("/test-file.txt");
        byte[] response = new MethodNotAllowedResponse().generate("/test-file.txt");
        assertArrayEquals(testResponse, response);
    }

    private class MockMethodNotAllowed {
        public byte[] generate(String requestURI) {
            String response = "HTTP/1.1 405 Method Not Allowed\r\n";
            return response.getBytes();
        }
    }
}
