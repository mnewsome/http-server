package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LogResponseTest {

   @Test
    public void testGenerate() {
       String testRequest = "POST /log HTTP/1.1\r\n" +
               "Connection: close\r\n" +
               "Host: localhost:5000\r\n" +
               "Content-Length: 10\r\n" +
               "Content-Type: application/x-www-form-urlencoded\r\n\r\n";
       byte[] testResponse = "HTTP/1.1 200 OK\r\n".getBytes();
       byte[] response = new LogResponse().generate(testRequest);
       assertArrayEquals("Log response", testResponse, response);
   }
}
