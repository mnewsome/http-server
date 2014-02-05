package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class RequestDirectorTest {

    @Test
    public void testRootResponse() {
        String request = getRequest();
        String response = getResponse();
        RequestDirector requestDirector = new RequestDirector();
        assertEquals("Response", response, requestDirector.routeRequestAndGetResponse(request));

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

    private String getResponse() {
        Date currentTime = new Date();
        String response = "HTTP/1.1 200 OK\r\n" +
        "Date: "+ currentTime +"\r\n" +
        "Server: Newsome-HTTP-Server\r\n" +
        "Content-type: text/html\r\n\r\n" +
        "<HTML><HEAD><TITLE>You got served!</TITLE><HEAD><BODY><H1>Hello World</H1>.DocumentRevisions-V100 .DS_Store .file .fseventsd .Spotlight-V100 .Trashes .vol Applications bin cores dev etc home Library mach_kernel net Network private sbin System tmp Users usr var Volumes </BODY></HTML>";
        return response;
    }
}
