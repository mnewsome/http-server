package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RedirectResponseTest {
    @Test
    public void testGenerate() throws Exception {
        String testResponse = new MockRedirectResponse().generate("/redirect");
        String response = new RedirectResponse().generate("/redirect");
        assertEquals("Redirect Response", testResponse, response);

    }

    private class MockRedirectResponse {
        public String generate(String requestURI) {
            String response = "HTTP/1.1 301 Permanently Moved\r\n" +
            "Location: http://localhost:5000/\r\n";
            return  response;
        }
    }
}
