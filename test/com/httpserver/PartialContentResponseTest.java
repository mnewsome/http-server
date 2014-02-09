package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertArrayEquals;

public class PartialContentResponseTest {
    @Test
    public void testGenerate() {
        byte[] testResponse = new MockPartialContentResponse().generate("/partial_content.txt");
        byte[] response = new PartialContentResponse().generate("/partial_content.txt");
        assertArrayEquals(testResponse, response);
    }

    private class MockPartialContentResponse {
        public byte[] generate(String requestURI) {
            Date currentDateTime = new Date();
            String response = 
                "HTTP/1.1 206 Partial Content\r\n" +
                "Date: " + currentDateTime + "\r\n" +
                "Server: Newsome-HTTP-Server\r\n" +
                "Content-type: text/plain\r\n\r\n" +
                "This";
            return response.getBytes();
        }

    }
}
