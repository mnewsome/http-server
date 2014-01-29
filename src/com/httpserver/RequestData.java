package com.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class RequestData {
    private final  Socket clientSocket;
    BufferedReader input;
    StringTokenizer token;

    public RequestData(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public String getRequest() throws IOException {
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String request = input.readLine();
        return request;
    }

    public String getRequestMethod() throws IOException {
        token = new StringTokenizer(this.getRequest());
        String requestMethod = token.nextToken();
        return requestMethod;
    }

    public String getRequestFile() throws IOException {
        token = new StringTokenizer(this.getRequest());
        token.nextToken();
        String fileName = token.nextToken();
        return fileName;
    }
}
