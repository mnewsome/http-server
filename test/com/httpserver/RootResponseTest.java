package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertArrayEquals;

public class RootResponseTest {
    @Test
    public void testGenerate() throws Exception {
        byte[] mockRootResponse = new MockRootResponse().generate("/");
        byte[] rootResponse = new RootResponse().generate("/");
        assertArrayEquals(mockRootResponse, rootResponse);
    }

    private class MockRootResponse {

        public byte[] generate (String requestURI) {
            Date currentTime = new Date();
            String response = String.format("HTTP/1.1 200 OK\r\n" +
                    "Date: " + currentTime + "\r\n" +
                    "Server: Newsome-HTTP-Server\r\n" +
                    "Content-type: text/html\r\n\r\n" +
                    "<HTML><HEAD><TITLE>You got served!</TITLE></HEAD>" +
                    "<BODY><H1>Hello World</H1>" +
                    "<a href=\"/file1\">file1</a>\r\n" +
                    "<a href=\"/file2\">file2</a>\r\n" +
                    "<a href=\"/image.gif\">image.gif</a>\r\n" +
                    "<a href=\"/image.jpeg\">image.jpeg</a>\r\n" +
                    "<a href=\"/image.png\">image.png</a>\r\n" +
                    "<a href=\"/partial_content.txt\">partial_content.txt</a>\r\n" +
                    "<a href=\"/text-file.txt\">text-file.txt</a>\r\n" +
                    "</BODY></HTML>");
            return response.getBytes();
        }
    }


}
