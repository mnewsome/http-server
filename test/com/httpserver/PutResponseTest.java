package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PutResponseTest {
    @Test
    public void testGenerate() {
        byte[] testResponse = new MockPutResponse().generate("/form");
        byte[] response = new PutResponse().generate("/form");
        assertArrayEquals(testResponse, response);
    }

    private class MockPutResponse {
        public byte[] generate(String requestURI) {
            String response = "HTTP/1.1 200 OK\r\n";
            return response.getBytes();
        }
    }
}