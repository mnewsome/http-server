package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BasicAuthResponseWithCredentialsTest {
    @Test
    public void testGenerate() throws Exception {
        byte[] response = new BasicAuthResponseWithCredentials().generate("/logs");
        byte [] testResponse = new MockBasicAuthResponseWithCredentials().generate("/logs");
        assertArrayEquals(testResponse, response);
    }

    private class MockBasicAuthResponseWithCredentials {
        public byte[] generate(String requestURI) {
            String response = "HTTP/1.1 200 OK\r\n\r\n" +
                "<HTML><BODY>GET /log HTTP/1.1</BODY></HTML>\r\n" +
                "<HTML><BODY>PUT /these HTTP/1.1</BODY></HTML>\r\n" +
                "<HTML><BODY>HEAD /requests HTTP/1.1</BODY></HTML>\r\n";
            return response.getBytes();
        }
    }
}
