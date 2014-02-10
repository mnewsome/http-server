package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ResponseGeneratorTest {
    @Test
    public void testGetStatusLine() throws Exception {
        byte[] testStatusLine = "HTTP/1.1 200 OK\r\n".getBytes();
        MockResponseGenerator mrg = new MockResponseGenerator();
        mrg.setStatus(200);
        assertArrayEquals(testStatusLine, mrg.getResponse());
    }

    private class MockResponseGenerator extends ResponseGenerator{
        @Override
        public byte[] generate(String requestURI) {
            return new byte[0];
        }

    }
}
