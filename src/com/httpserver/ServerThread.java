package com.httpserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    private final Socket clientSocket;
    private final RequestDirector requestDirector;

    public ServerThread(Socket clientSocket, RequestDirector requestDirector) {
        this.clientSocket = clientSocket;
        this.requestDirector = requestDirector;
    }

    public void run() {
        BufferedReader input;
        DataOutputStream output;

        try {
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            RequestParser requestParser = new RequestParser();
            String request = requestParser.getRequest(input);
            String response = requestDirector.routeRequestAndGetResponse(request);
            output = new DataOutputStream(clientSocket.getOutputStream());
            output.write(response.getBytes());
            output.close();
            input.close();

        } catch (IOException e) {
            System.out.println("Request could not be processed");
            e.printStackTrace();
        }


    }
}
