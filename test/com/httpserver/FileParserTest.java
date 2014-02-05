package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileParserTest {
    @Test
    public void testIsDirectory() {
        FileParser fp = new FileParser("/root/");
        assertTrue(fp.isDirectory());
    }

    @Test
    public void testIsNotDirectory() {
        FileParser fp = new FileParser("/root");
        assertFalse(fp.isDirectory());
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
        assertEquals("Content Length", "10", fp.getContentLength());
    }

    @Test
    public void testIsImage() {
        FileParser fp = new FileParser("image.png");
        assertTrue(fp.isImage());
    }

    @Test
    public void testIsNotImage() {
        FileParser fp = new FileParser("image.html");
        assertFalse(fp.isImage());
    }

    @Test
    public void testGetDecodedFile() {
        FileParser fp = new FileParser("/partial_content.txt");
        assertEquals("Decoded file", "I like to eat food\n", fp.getDecodedFile("/partial_content.txt"));
    }
}
