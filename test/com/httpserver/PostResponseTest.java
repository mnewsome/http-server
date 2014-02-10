package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PostResponseTest {

    @Test
    public void testGenerate() {
        String testRequest = "POST /form HTTP/1.1\r\n" +
        "Connection: close\r\n" +
        "Host: localhost:5000\r\n" +
        "Content-Length: 10\r\n" +
        "Content-Type: application/x-www-form-urlencoded\r\n\r\n" +
        "data=cosby";
        byte[] testResponse = new MockPostResponse().generate(testRequest);
        byte[] response = new PostResponse().generate(testRequest);
        assertArrayEquals(testResponse, response);

    }

    private class MockPostResponse {
        public byte[] generate(String request) {
            String response = "HTTP/1.1 200 OK\r\n";
            return response.getBytes();
        }
    }
}
