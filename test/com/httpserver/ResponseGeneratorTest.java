package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertArrayEquals;

public class ResponseGeneratorTest {
    @Test
    public void testGetStatusLine() throws Exception {
        byte[] testStatusLine = "HTTP/1.1 200 OK\r\n".getBytes();
        MockResponseGenerator mrg1 = new MockResponseGenerator();
        assertArrayEquals(testStatusLine, mrg1.getStatusLine(200).getBytes());
    }

    @Test
    public void testGetContentType() {
        byte[] testResponse = "Content-type: text/html\r\n\r\n".getBytes();
        MockResponseGenerator mrg2 = new MockResponseGenerator();
        assertArrayEquals(testResponse, mrg2.getContentType("txt/html").getBytes());
    }

    @Test
    public void testGetDateHeader() {
        Date currentTime = new Date();
        byte[] testResponse = String.format("Date: %s\r\n", currentTime).getBytes();
        MockResponseGenerator mrg3 = new MockResponseGenerator();
        assertArrayEquals(testResponse, mrg3.getDateHeader().getBytes());
    }

    @Test
    public void testGetServerInfoHeader() {
        byte[] testResponse = "Server: Newsome-HTTP-Server\r\n".getBytes();
        MockResponseGenerator mrg4 = new MockResponseGenerator();
        assertArrayEquals(testResponse, mrg4.getServerInfoHeader().getBytes());
    }

    private class MockResponseGenerator extends ResponseGenerator{
        @Override
        public byte[] generate(String requestURI) {
            return new byte[0];
        }

    }
}
