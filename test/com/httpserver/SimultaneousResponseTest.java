package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SimultaneousResponseTest {
    @Test
    public void testGenerate() {
        byte[] testResponse = "HTTP/1.1 200 OK\r\n".getBytes();
        byte[]  response = new SimultaneousResponse().generate("/");
        assertArrayEquals(testResponse,response);

    }
}
