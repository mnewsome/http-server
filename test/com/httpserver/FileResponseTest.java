package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileResponseTest {
    @Test
    public void testGenerate() {
        String mockFileResponse = new MockFileResponse().generate("index.html");
        String fileResponse = new FileResponse().generate("index.html");
        assertEquals("File Found Response", mockFileResponse, fileResponse);
    }
}
