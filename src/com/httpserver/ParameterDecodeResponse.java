package com.httpserver;

import java.net.URLDecoder;

public class ParameterDecodeResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {

        String separateURI = requestURI.replaceAll("=", " = ");
        String[] queryStrings = separateURI.split("&");

        String firstVariable = URLDecoder.decode(queryStrings[0].replace("/parameters?", ""));
        String secondVariable = queryStrings[1];

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine(200));
        responseBuilder.append(getDateHeader());
        responseBuilder.append(getServerInfoHeader());
        responseBuilder.append(getContentType("text/html"));
        responseBuilder.append("<HTML><BODY>");
        responseBuilder.append(firstVariable + "\r\n");
        responseBuilder.append(secondVariable + "\r\n");
        responseBuilder.append("</BODY></HTML>");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
