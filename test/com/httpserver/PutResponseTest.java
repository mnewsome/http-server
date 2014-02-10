package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PutResponseTest {
    @Test
    public void testGenerate() {
        String testRequest = "PUT /form HTTP/1.1\r\n" +
                "Connection: close\r\n" +
                "Host: localhost:5000\r\n" +
                "Content-Length: 10\r\n" +
                "Content-Type: application/x-www-form-urlencoded\r\n\r\n" +
                "data=cosby";
        byte[] testResponse = new MockPutResponse().generate(testRequest);
        byte[] response = new PutResponse().generate(testRequest);
        assertArrayEquals(testResponse, response);
    }

    private class MockPutResponse {
        public byte[] generate(String requestURI) {
            String response = "HTTP/1.1 200 OK\r\n";
            return response.getBytes();
        }
    }
}