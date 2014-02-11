package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertArrayEquals;

public class StandardSuccessResponseTest {
    @Test
    public void testGenerate() {
        byte[] testResponse = new MockStandardSuccessResponse().generate("/form");
        byte[] response = new StandardSuccessResponse().generate("/form");
        assertArrayEquals(testResponse, response);
    }

    private class MockStandardSuccessResponse {
        public byte[] generate(String requestURI) {
            Date currentTime = new Date();
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Date: " + currentTime + "\r\n" +
                    "Server: Newsome-HTTP-Server\r\n" +
                    "Content-type: text/html\r\n\r\n" +
                    "<HTML><BODY>" +
                    "data = cosby" +
                    "</BODY></HTML>";
            return response.getBytes();
        }
    }
}
