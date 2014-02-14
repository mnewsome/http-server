package com.httpserver;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testGetHeaderLine() {
        String testRequest = getRequest();
        String headerLine = new RequestParser().getHeaderLine(testRequest);
        assertEquals("Header Line", "GET / HTTP/1.1", headerLine);
    }
    public void testGetContentLength() {
        String testRequestLine = "Content-length: 10\r\n";
        String contentLength = new RequestParser().getContentLength(testRequestLine);
        assertEquals("Content Length", "10", contentLength);
    }

    @Test
    public void testRequestHeaderContains() {
       String request = getRequest();
       boolean headerToTest = new RequestParser().requestHeaderContains(request, "Connection: keep-alive");
       assertTrue(headerToTest);
    }

    @Test
    public void testGetBodyData() {
        String testRequest = postRequest();
        String bodyData = new RequestParser().getBodyData(testRequest);
        assertEquals("Body data", "data = cosby", bodyData );
    }

    private String getRequest() {
        String request = "GET / HTTP/1.1\r\n" +
                "Host: localhost:5000\r\n" +
                "Connection: keep-alive\r\n" +
                "Cache-Control: max-age=0\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36\r\n" +
                "Accept-Encoding: gzip,deflate,sdch\r\n"+
                "Accept-Language: en-US,en;q=0.8\r\n\r\n";
        return request;
    }

    private String postRequest() {
        String request = "New thread started on port 5000\n" +
                "POST /form HTTP/1.1\r\n" +
                "Connection: close\r\n" +
                "Host: localhost:5000\r\n" +
                "Content-Length: 10\r\n" +
                "Content-Type: application/x-www-form-urlencoded\r\n" +
                "data=cosby";
        return request;
    }

    private BufferedReader getInput() {
        String request = getRequest();
        InputStream inputStream = new ByteArrayInputStream(request.getBytes());
        BufferedReader bufferedInput = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedInput;
    }



}
