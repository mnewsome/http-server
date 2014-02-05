package com.httpserver;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ParameterDecodeResponseTest {
    @Test
    public void testGenerate() {
        String requestURI = "/parameters?variable_1=Operators%20%3C%2C%20%3E%2C%20%3D%2C%20!%3D%3B%20%2B%2C%20-%2C%20*%2C%20%26%2C%20%40%2C%20%23%2C%20%24%2C%20%5B%2C%20%5D%3A%20%22is%20that%20all%22%3F&variable_2=stuff";
        String testResponse = new MockParameterDecodeResponse().generate(requestURI);
        String resonse = new ParameterDecodeResponse().generate(requestURI);
        assertEquals("Parameter Decode Response", testResponse, resonse);
    }


    private class MockParameterDecodeResponse {
        public String generate(String requestURI) {
            Date currentTime = new Date();
            String response = "HTTP/1.1 200 OK\r\n" +
                "Date: " + currentTime + "\r\n" +
                "Server: Newsome-HTTP-Server\r\n" +
                "Content-type: text/html \r\n\r\n" +
                "<HTML><BODY>" +
                "variable_1 = Operators <, >, =, !=; +, -, *, &, @, #, $, [, ]: \"is that all\"?\r\n" +
                "variable_2 = stuff\r\n" +
                "</BODY></HTML>";
            return response;
        }
    }
}
