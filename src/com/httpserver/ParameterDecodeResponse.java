package com.httpserver;

import java.net.URLDecoder;
import java.util.Date;

public class ParameterDecodeResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {
        StringBuilder responseBuilder = new StringBuilder();
        String separateURI = requestURI.replaceAll("=", " = ");
        String[] queryStrings = separateURI.split("&");

        String firstVariable = URLDecoder.decode(queryStrings[0].replace("/parameters?", ""));
        String secondVariable = queryStrings[1];

        Date currentTime = new Date();
        responseBuilder.append("HTTP/1.1 200 OK\r\n");
        responseBuilder.append("Date: " + currentTime + "\r\n");
        responseBuilder.append("Server: Newsome-HTTP-Server\r\n");
        responseBuilder.append("Content-type: text/html \r\n\r\n");
        responseBuilder.append("<HTML><BODY>");
        responseBuilder.append(firstVariable + "\r\n");
        responseBuilder.append(secondVariable + "\r\n");
        responseBuilder.append("</BODY></HTML>");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
