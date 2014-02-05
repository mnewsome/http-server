package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FileResponseTest {
    @Test
    public void testGenerate() {
        String mockFileResponse = new MockFileResponse().generate("index.html");
        String fileResponse = new FileResponse().generate("index.html");
        assertEquals("File Found Response", mockFileResponse, fileResponse);
    }

    private class MockFileResponse {
        public String generate (String requestURI) {
            Date currentTime = new Date();
            FileParser fileParser = new FileParser(requestURI);
            String response = String.format("HTTP/1.1 200 OK\r\n" +
                    "Date: " + currentTime + "\r\n" +
                    "Server: Newsome-HTTP-Server\r\n" +
                    "Content-length: "+ fileParser.getContentLength() + "\r\n" +
                    "Content-type: " + fileParser.getContentType() +"\r\n\r\n" +
                    "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "\n" +
                    "<head/>\n" +
                    "  <title>You got served</title>\n" +
                    "</head>\n" +
                    "\n" +
                    "<p>Hello World</p>\n" +
                    "\n" +
                    "<img src=\"http://stream1.gifsoup.com/view/364126/c-breezy-smile-o.gif\" />\n" +
                    "\n" +
                    "</html>\n");

            return response;
        }
    }
}
