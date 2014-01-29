package com.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class Data {
    private final  Socket clientSocket;
    BufferedReader input;

    public Data (Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    public String getRequest() throws IOException {
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String request = input.readLine();
        return request;
    }

    public String getRequestMethod() throws IOException{
        StringTokenizer token = new StringTokenizer(this.getRequest());
        String requestMethod = token.nextToken();
        return requestMethod;
    }
}
