package com.httpserver;

import java.io.File;
import java.util.Date;

public class RootResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {
        File directory = new File("/Users/mnewsome/cob_spec/public/");
        File[] fileListing = directory.listFiles();
        Date currentTime = new Date();

        setStatus(200);
        setDate(currentTime);
        setContentType("text/html");

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine());
        responseBuilder.append(getDateHeader());
        responseBuilder.append(getServerInfoHeader());
        responseBuilder.append(getContentType());
        responseBuilder.append("<HTML><HEAD><TITLE>You got served!</TITLE></HEAD>");
        responseBuilder.append("<BODY><H1>Hello World</H1>");

        for (String file : directory.list()) {
            responseBuilder.append("<a href=\"/" + file + "\">" + file + "</a>\r\n");
        }

        responseBuilder.append("</BODY></HTML>");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}