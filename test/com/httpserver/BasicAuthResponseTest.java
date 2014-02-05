package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicAuthResponseTest {
    @Test
    public void testGenerate() {
        String testResponse = new MockBasicAuthResponse().generate("/logs");
        String response = new BasicAuthResponse().generate("/logs");
        assertEquals("Basic Auth Response", testResponse, response);
    }

    private class MockBasicAuthResponse {
        public String generate(String requestURI) {
            String response = "HTTP/1.1 401 Unauthorized\r\n" +
                    "WWW-Authenticate: Basic realm=\"logs\"\r\n\r\n" +
                    "<HTML><BODY>Authentication required</BODY></HTML>";
            return response;
        }
    }
}
