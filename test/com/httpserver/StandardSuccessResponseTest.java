package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class StandardSuccessResponseTest {
    @Test
    public void testGenerate() {
        byte[] testResponse = new MockStandardSuccessResponse().generate("/form");
        byte[] response = new StandardSuccessResponse().generate("/form");
        assertArrayEquals(testResponse, response);
    }

    private class MockStandardSuccessResponse {
        public byte[] generate(String requestURI) {
            String response = "HTTP/1.1 200 OK\r\n";
            return response.getBytes();
        }
    }
}
