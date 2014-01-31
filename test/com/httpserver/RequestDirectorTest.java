package com.httpserver;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertEquals;


public class RequestDirectorTest {

    @Test
    public void testGetRequest() throws IOException {
        String localhost = "192.168.1.65";
        ServerSocket ss = new ServerSocket(5000);
        Socket testSocket = ss.accept();
        BufferedReader input = new BufferedReader(new InputStreamReader(testSocket.getInputStream()));
        RequestDirector requestDirector = new RequestDirector(input);
        ss.close();
        assertEquals("Request line", "GET /index.html HTTP/1.1", requestDirector.getRequest());
    }

    @Test
    public void testGetRequestMethod() throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        Socket testSocket = ss.accept();
        BufferedReader input = new BufferedReader(new InputStreamReader(testSocket.getInputStream()));
        RequestDirector requestDirector = new RequestDirector(input);
        ss.close();
        assertEquals("Request method", "GET", requestDirector.getRequestMethod());
    }

    @Test
    public void  testGetRequestFileName() throws IOException {
        String requestLine = "GET /index.html HTTP/1.1";
        ServerSocket ss = new ServerSocket(5000);
        Socket testSocket = ss.accept();
        BufferedReader input = new BufferedReader(new InputStreamReader(testSocket.getInputStream()));
        RequestDirector requestDirector = new RequestDirector(input);
        assertEquals("Request File", "/index.html", requestDirector.getRequestFile(requestLine));
    }

}
