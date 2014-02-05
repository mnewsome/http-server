package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MethodNotAllowedResponseTest {
    @Test
    public void testGenerate() {
        String testResponse = new MockMethodNotAllowed().generate("/test-file.txt");
        String response = new MethodNotAllowedResponse().generate("/test-file.txt");
        assertEquals("Method not allowed", testResponse, response);
    }
}
