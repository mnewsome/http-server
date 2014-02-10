package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PostResponseTest {

    @Test
    public void testGenerate() {
        byte[] testResponse = new MockPostResponse().generate("/form");
        byte[] response = new PostResponse().generate("/form");
        assertArrayEquals(testResponse, response);

    }

    private class MockPostResponse {
        public byte[] generate(String requestURI) {
            String response = "HTTP/1.1 200 OK\r\n";
            return response.getBytes();
        }
    }
}
