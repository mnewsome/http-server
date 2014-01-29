package com.httpserver;

import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertEquals;


public class RequestDataTest {

    @Test
    public void testGetRequest() throws IOException {
        String localhost = "192.168.1.65";
        ServerSocket ss = new ServerSocket(5000);
        Socket testSocket = ss.accept();
        RequestData requestData = new RequestData(testSocket);
        ss.close();
        assertEquals("Request line", "GET /index.html HTTP/1.1", requestData.getRequest());
    }

    @Test
    public void testGetRequestMethod() throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        Socket testSocket = ss.accept();
        RequestData requestData = new RequestData(testSocket);
        ss.close();
        assertEquals("Request method", "GET", requestData.getRequestMethod());
    }

    @Test
    public void  testGetRequestFileName() throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        Socket testSocket = ss.accept();
        RequestData requestData = new RequestData(testSocket);
        ss.close();
        assertEquals("Request File", "/index.html", requestData.getRequestFile());
    }

}
