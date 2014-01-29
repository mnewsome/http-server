package com.httpserver;

import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertEquals;


public class DataTest {

    @Test
    public void testGetRequest() throws IOException {
        String localhost = "192.168.1.65";
        ServerSocket ss = new ServerSocket(5000);
        Socket testSocket = ss.accept();
        Data data = new Data(testSocket);
        ss.close();
        assertEquals("Request line", "GET / HTTP/1.1", data.getRequest());
    }

    @Test
    public void testGetRequestMethod() throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        Socket testSocket = ss.accept();
        Data data = new Data(testSocket);
        assertEquals("Request method", "GET", data.getRequestMethod());
    }

}
