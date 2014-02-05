package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class RootResponseTest {
    @Test
    public void testGenerate() throws Exception {
        String mockRootResponse = new MockRootResponse().generate("/");
        String rootResponse = new RootResponse().generate("/");
        assertEquals("Root Response", mockRootResponse, rootResponse);
    }

    private class MockRootResponse {

        public String generate (String requestURI) {
            Date currentTime = new Date();
            String response = String.format("HTTP/1.1 200 OK\r\n" +
                    "Date: " + currentTime + "\r\n" +
                    "Server: Newsome-HTTP-Server\r\n" +
                    "Content-type: text/html \r\n\r\n" +
                    "<HTML><HEAD><TITLE>You got served!</TITLE><HEAD>" +
                    "<BODY><H1><BODY>Hello World</H1></BODY></HTML>");
            return response;
        }
    }


}
