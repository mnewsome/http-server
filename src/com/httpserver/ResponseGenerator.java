package com.httpserver;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class ResponseGenerator {
    private Date currentTime;


    public abstract byte[] generate(String requestURI);

    public String getStatusLine(Integer statusCode) {
        Map<Integer, String> statusLine = new HashMap<Integer, String>();

        statusLine.put(200, "200 OK");
        statusLine.put(206, "206 Partial Content");
        statusLine.put(301, "301 Permanently Moved");
        statusLine.put(401, "401 Unauthorized");
        statusLine.put(404, "404 File Not Found");
        statusLine.put(405, "405 Method Not Allowed");

        return "HTTP/1.1 " + statusLine.get(statusCode) + "\r\n";
    }

    public String getDateHeader() {
        Date currentTime = new Date();
        return "Date: " + currentTime + "\r\n";
    }

    public String getServerInfoHeader() {
        return "Server: Newsome-HTTP-Server\r\n";
    }

    public  String getContentType(String contentType) {
        return "Content-type: " + contentType + "\r\n\r\n";
    }
}
