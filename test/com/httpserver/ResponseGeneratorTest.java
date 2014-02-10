package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ResponseGeneratorTest {
    @Test
    public void testGetStatusLine() throws Exception {
        byte[] testStatusLine = "HTTP/1.1 200 OK\r\n".getBytes();
        MockResponseGenerator mrg = new MockResponseGenerator();
        mrg.setStatus(200);
        assertArrayEquals(testStatusLine, mrg.getStatusLine().getBytes());
    }

    @Test
    public void testGetContentType() {
        byte[] testResponse = "Content-type: text/html\r\n\r\n".getBytes();
        MockResponseGenerator mrg1 = new MockResponseGenerator();
        mrg1.setContentType("text/html");
        assertArrayEquals(testResponse, mrg1.getContentType().getBytes());
    }

    private class MockResponseGenerator extends ResponseGenerator{
        @Override
        public byte[] generate(String requestURI) {
            return new byte[0];
        }

    }
}
