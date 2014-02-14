package com.httpserver;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestParser {
    public RequestParser() {
    }

    public String getRequest(BufferedReader clientInput) throws IOException {
        StringBuilder request = new StringBuilder();
        String line;
        String contentLength = null;
        char[] bodyCharacters = new char[0];
        while (!(line = clientInput.readLine()).equals("")) {
            request.append(line + "\r\n");

        }
        String body = "";
        if(requestHeaderContains(request.toString(), "Content-Length"))
            body = getBody(clientInput);
        System.out.println(request.toString() + body);
        return request.toString() +"\r\n" + body;
    }

    private String getBody(BufferedReader clientInput) throws IOException {
        StringBuilder request = new StringBuilder();
        while (clientInput.ready()) {
            request.append((char) clientInput.read());
        }
        return getBodyData(request.toString());
    }

    public String getContentLength(String requestLine) {
        return requestLine.split(": ")[1];
    }

    public String getBodyData(String request) {
        String[] splitRequest = request.split("\r\n");
        return splitRequest[splitRequest.length - 1].replace("=", " = ");
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

    public String getHeaderLine(String request) {
        return request.split("\r\n")[0];
    }
}
