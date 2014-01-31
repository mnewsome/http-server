package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileParserTest {
    @Test
    public void testIsDirectory() {
        FileParser fp = new FileParser("/root/");
        assertTrue(fp.getRequestFile());
    }

    @Test
    public void testIsNotDirectory() {
        FileParser fp = new FileParser("/root");
        assertFalse(fp.getRequestFile());
    }

    @Test
    public void testGetHTMLContentType() {
        FileParser fp = new FileParser("index.html");
        assertEquals("HTML Content type", "text/html", fp.getContentType());
    }

    @Test
    public void testGetTXTContentType() {
        FileParser fp = new FileParser("file.txt");
        assertEquals("TXT Content type", "text/plain", fp.getContentType());
    }

    @Test
    public void testGetJPGContentType() {
        FileParser fp = new FileParser("image.jpeg");
        assertEquals("JPEG Content type", "image/jpeg", fp.getContentType());
    }

    @Test
    public void testGetGIFContentType() {
        FileParser fp = new FileParser("image.gif");
        assertEquals("GIF Content type", "image/gif", fp.getContentType());
    }

    @Test
    public void testGetPNGContentType() {
        FileParser fp = new FileParser("image.png");
        assertEquals("PNG Content type", "image/png", fp.getContentType());
    }

    @Test
    public void  testGetContentLength() {
        FileParser fp = new FileParser("index.html");
        assertEquals("Content Length", "0", fp.getContentLength());
    }
}
