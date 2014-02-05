package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicAuthResponseTest {
    @Test
    public void testGenerate() {
        String testResponse = new MockBasicAuthResponse().generate("/logs");
        String response = new BasicAuthResponse().generate("/logs");
        assertEquals("Basic Auth Response", testResponse, response);
    }
}
