package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RootResponseTest {
    @Test
    public void testGenerate() throws Exception {
        String mockRootResponse = new MockRootResponse().generate("/");
        String rootResponse = new RootResponse().generate("/");
        assertEquals("Root Response", mockRootResponse, rootResponse);
    }


}
