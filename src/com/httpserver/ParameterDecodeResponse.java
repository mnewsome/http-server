package com.httpserver;

import java.net.URLDecoder;
import java.util.Date;

public class ParameterDecodeResponse extends ResponseGenerator{
    @Override
    public String generate(String requestURI) {
        StringBuilder response = new StringBuilder();
        String separateURI = requestURI.replaceAll("=", " = ");
        String[] queryStrings = separateURI.split("&");

        String firstVariable = URLDecoder.decode(queryStrings[0].replace("/parameters?", ""));
        String secondVariable = queryStrings[1];

        Date currentTime = new Date();
        response.append("HTTP/1.1 200 OK\r\n");
        response.append("Date: " + currentTime + "\r\n");
        response.append("Server: Newsome-HTTP-Server\r\n");
        response.append("Content-type: text/html \r\n\r\n");
        response.append("<HTML><BODY>");
        response.append(firstVariable + "\r\n");
        response.append(secondVariable + "\r\n");
        response.append("</BODY></HTML>");
        return response.toString();
    }
}
