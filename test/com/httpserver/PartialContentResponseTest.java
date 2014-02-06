package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PartialContentResponseTest {
    @Test
    public void testGenerate() {
        String testResponse = new MockPartialContentResponse().generate("/partial_content.txt");
        String response = new PartialContentResponse().generate("/partial_content.txt");
        assertEquals("Partial Content", testResponse, response); 
    }

    private class MockPartialContentResponse {
        public String generate(String requestURI) {
            Date currentDateTime = new Date();
            String response = 
                "HTTP/1.1 206 Partial Content\r\n" +
                "Date: " + currentDateTime + "\r\n" +
                "Server: Newsome-HTTP-Server\r\n" +
                "Content-length: 20\r\n" +
                "Content-type: text/plain\r\n\r\n" +
                "I like to eat food!\r\n";

            return response;
        }

    }
}
