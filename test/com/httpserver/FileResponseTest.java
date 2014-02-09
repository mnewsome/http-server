package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertArrayEquals;

public class FileResponseTest {
    @Test
    public void testGenerate() {
        byte[] mockFileResponse = new MockFileResponse().generate("file1");
        byte[] fileResponse = new FileResponse().generate("file1");
        assertArrayEquals(mockFileResponse, fileResponse);
    }

    private class MockFileResponse {
        public byte[] generate (String requestURI) {
            Date currentTime = new Date();
            FileParser fileParser = new FileParser(requestURI);
            String response = String.format("HTTP/1.1 200 OK\r\n" +
                    "Date: " + currentTime + "\r\n" +
                    "Server: Newsome-HTTP-Server\r\n" +
                    "Content-type: text/html\r\n\r\n" +
                    "<HTML><BODY>" +
                    "file1 contents\n" +
                    "</BODY></HTML>");

            return response.getBytes();
        }
    }
}
