package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MethodOptionsResponseTest {
    @Test
    public void testGenerate() {
        String testResponse = new MockMethodOptionsResponse().generate("/method_options");
        String response = new MethodOptionsResponse().generate("/method_options");
        assertEquals("Method options response", testResponse, response);
    }
}
