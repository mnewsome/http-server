package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FileDoesNotExistResponseTest {
    @Test
    public void testGenerate() {
        String testNoFile = new MockFileDoesNotExistResponse().generate("/foobar");
        String noFile = new FileDoesNotExistResponse().generate("/foobar");
        assertEquals("File Not Found", testNoFile, noFile);
    }
    public class MockFileDoesNotExistResponse {
        public String generate (String requestURI) {
            Date currentTime = new Date();
            String response = String.format("HTTP/1.1 404 File Not Found\r\n" +
                    "Date: " + currentTime + "\r\n" +
                    "Server: Newsome-HTTP-Server\r\n");
            return response;
        }
    }


}
