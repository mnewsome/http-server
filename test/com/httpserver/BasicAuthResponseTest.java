package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BasicAuthResponseTest {
    @Test
    public void testGenerate() {
        byte[] testResponse = new MockBasicAuthResponse().generate("/logs");
        byte[] response = new BasicAuthResponse().generate("/logs");
        assertArrayEquals(testResponse, response);
    }

    private class MockBasicAuthResponse {
        public byte[] generate(String requestURI) {
            String response = "HTTP/1.1 401 Unauthorized\r\n" +
                "Authorization: Basic YWRtaW46aHVudGVyMg==\r\n\r\n" +
                "<HTML><BODY>Authentication required</BODY></HTML>\r\n";
            return response.getBytes();
        }
    }
}