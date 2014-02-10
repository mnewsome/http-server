package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RedirectResponseTest {
    @Test
    public void testGenerate() throws Exception {
        byte[] testResponse = new MockRedirectResponse().generate("/redirect");
        byte[] response = new RedirectResponse().generate("/redirect");
        assertArrayEquals(testResponse, response);
    }

    private class MockRedirectResponse {
        public byte[] generate(String requestURI) {
            String response = "HTTP/1.1 301 Permanently Moved\r\n" +
            "Location: http://localhost:5000/\r\n";
            return response.getBytes();
        }
    }
}
