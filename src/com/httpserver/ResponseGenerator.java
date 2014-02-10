package com.httpserver;

import java.util.HashMap;
import java.util.Map;

public abstract class ResponseGenerator {
    private int responseStatusCode;
    private String contentType;

    public abstract byte[] generate(String requestURI);

    public void setStatus(int responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }

    private String getStatusLine() {
        Map<Integer, String> statusLine = new HashMap<Integer, String>();

        statusLine.put(200, "200 OK");
        statusLine.put(206, "206 Partial Content");
        statusLine.put(301 , "301 Permanently Moved");
        statusLine.put(401, "401 Unauthorized");
        statusLine.put(404, "404 File Not Found");
        statusLine.put(405, "405 Method Not Allowed");

        return "HTTP/1.1 " + statusLine.get(this.responseStatusCode) + "\r\n";
    }

    public byte[] getResponse() {
        StringBuilder response = new StringBuilder();
        response.append(getStatusLine());
        response.append(getContentType());
        return response.toString().getBytes();
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    private String getContentType() {
        return "Content-type: " + this.contentType + "\r\n\r\n";
    }
}
