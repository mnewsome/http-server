package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileParserTest {

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
    public void testGetDecodedFile() {
        FileParser fp = new FileParser("/partial_content.txt");
        assertEquals("Decoded file", "This is a file that contains text to read part of in order to fulfill a 206.\n", fp.getDecodedFile("/partial_content.txt"));
    }

    @Test
    public void testGetFileData() {
        FileParser fp = new FileParser("/partial_content");
        byte[] testData = "This is a file that contains text to read part of in order to fulfill a 206.\n".getBytes();
        assertArrayEquals(testData, fp.getFileData("/partial_content.txt"));
    }
}
