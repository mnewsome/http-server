package com.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class RequestDirector {
    private final  BufferedReader clientInput;
    StringTokenizer token;

    public RequestDirector(BufferedReader clientInput) {
        this.clientInput = clientInput;
    }

    public String getRequest() throws IOException {
        StringBuilder request = new StringBuilder();
        while (clientInput.ready()) {
            request.append((char) clientInput.read());
        }
        return request.toString();
    }

    public String getRequestMethod(String request) {
        String[] headerLineParts = getHeaderLineParts(request);
        String requestMethod = headerLineParts[0];
        return requestMethod;
    }

    public String getRequestFile(String request) {
        String[] headerLineParts = getHeaderLineParts(request);
        String fileName = headerLineParts[1];
        return fileName;
    }

    private String[] getHeaderLineParts(String request) {
        String[] headerLine = request.split("\r\n");
        String[] headerLineParts = headerLine[0].split(" ");
        return headerLineParts;
    }
}
