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
        String request = clientInput.readLine();
//        while (!(request = input.readLine()).equals("")) {
//            System.out.println(request);
//        }
        return request;
    }

    public String getRequestMethod() throws IOException {
        token = new StringTokenizer(this.getRequest());
        String requestMethod = token.nextToken();
        return requestMethod;
    }

    public String getRequestFile(String requestLine) throws IOException {
        token = new StringTokenizer(requestLine);
        token.nextToken();
        String fileName = token.nextToken();
        return fileName;
    }
}
