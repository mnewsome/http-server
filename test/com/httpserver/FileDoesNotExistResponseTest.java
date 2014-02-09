package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertArrayEquals;

public class FileDoesNotExistResponseTest {
    @Test
    public void testGenerate() {
        byte[] testNoFile = new MockFileDoesNotExistResponse().generate("/foobar");
        byte[] noFile = new FileDoesNotExistResponse().generate("/foobar");
        assertArrayEquals(testNoFile, noFile);
    }
    public class MockFileDoesNotExistResponse {
        public byte[] generate (String requestURI) {
            Date currentTime = new Date();
            String response = String.format("HTTP/1.1 404 File Not Found\r\n" +
                    "Date: " + currentTime + "\r\n" +
                    "Server: Newsome-HTTP-Server\r\n");
            return response.getBytes();
        }
    }


}
