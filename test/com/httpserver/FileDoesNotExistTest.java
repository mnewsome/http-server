package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileDoesNotExistTest {
    @Test
    public void testGenerate() {
        String testNoFile = new MockFileDoesNotExistResponse().generate("/foobar");
        String noFile = new FileDoesNotExist().generate("/foobar");
        assertEquals("File Not Found", testNoFile, noFile);
    }


}
