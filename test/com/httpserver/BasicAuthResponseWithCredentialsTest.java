package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicAuthResponseWithCredentialsTest {
    @Test
    public void testGenerate() throws Exception {
        String response = new BasicAuthResponseWithCredentials().generate("/logs");
        String testResponse = new MockBasicAuthResponseWithCredentials().generate("/logs");
        assertEquals("Basic Auth Response With Credentials", testResponse, response);
    }

    private class MockBasicAuthResponseWithCredentials {
        public String generate(String requestURI) {
            String response = "HTTP/1.1 200 OK\r\n\r\n" +
                "<HTML><BODY>GET /log HTTP/1.1</BODY></HTML>\r\n" +
                "<HTML><BODY>PUT /these HTTP/1.1</BODY></HTML>\r\n" +
                "<HTML><BODY>HEAD /requests HTTP/1.1</BODY></HTML>\r\n";
            return response;
        }
    }
}
