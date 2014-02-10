package com.httpserver;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestParser {
    public String getRequest(BufferedReader clientInput) throws IOException {
        StringBuilder request = new StringBuilder();
        while (clientInput.ready()) {
            request.append((char) clientInput.read());
        }
        System.out.println(request.toString());
        return request.toString();
    }

    public String getRequestMethod(String request) {
        String[] headerLineParts = getHeaderLineParts(request);
        String requestMethod = headerLineParts[0];
        return requestMethod;
    }

    public String getRequestURI(String request) {
        String requestURI = "";
        if (!request.equals("")) {
            String[] headerLineParts = getHeaderLineParts(request);
            requestURI = headerLineParts[1];
        }
        return requestURI;
    }

    private String[] getHeaderLineParts(String request) {
        String[] headerLine = request.split("\r\n");
        String[] headerLineParts = headerLine[0].split(" ");
        return headerLineParts;
    }

    public boolean requestHeaderContains(String request, String headerToTest) {
        return request.contains(headerToTest);
    }

    public String getBodyData(String request) {
        String[] splitRequest = request.split("\r\n\r\n");
        return splitRequest[1].replace("=", " = ");
    }
}
