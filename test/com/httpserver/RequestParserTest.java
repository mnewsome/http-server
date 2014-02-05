package com.httpserver;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class RequestParserTest {

    @Test
    public void testGetRequest() throws IOException {
        BufferedReader testInput = getInput();
        String testRequest = getRequest();
        String request = new RequestParser().getRequest(testInput);
        assertEquals("Request string", testRequest, request);
    }

    @Test
    public void testGetRequestMethod() {
        String testRequest = getRequest();
        String requestMethod = new RequestParser().getRequestMethod(testRequest);
        assertEquals("Request Method", "GET", requestMethod);
    }

    @Test
    public void testGetRequestURI() {
        String testRequest = getRequest();
        String requestURI = new RequestParser().getRequestURI(testRequest);
        assertEquals("Request URI", "/", requestURI);
    }

    private String getRequest() {
        String request = "GET / HTTP/1.1 " +
                "Host: localhost:5000" +
                "Connection: keep-alive" +
                "Cache-Control: max-age=0" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36" +
                "Accept-Encoding: gzip,deflate,sdch"+
                "Accept-Language: en-US,en;q=0.8";
        return request;
    }

    private BufferedReader getInput() {
        String request = getRequest();
        InputStream inputStream = new ByteArrayInputStream(request.getBytes());
        BufferedReader bufferedInput = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedInput;
    }

}
