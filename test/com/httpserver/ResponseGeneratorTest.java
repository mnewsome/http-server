package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResponseGeneratorTest {
    @Test
    public void testRootResponse() {

        ResponseGenerator rg = new ResponseGenerator("/");
        assertEquals("Request of root returns hello world", "Hello World", rg.rootResponse());
    }



}
