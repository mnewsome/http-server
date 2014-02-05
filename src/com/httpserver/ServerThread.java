package com.httpserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    private final String rootDirectory;
    private final Socket clientSocket;

    public ServerThread(String rootDirectory, Socket clientSocket) {
        this.rootDirectory = rootDirectory;
        this.clientSocket = clientSocket;
    }

    public void run() {
        BufferedReader input;
        DataOutputStream output;

        try {
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            RequestDirector requestDirector = new RequestDirector();
            String request = requestDirector.getRequest(input);
            System.out.println(request);
            String requestURI = requestDirector.getRequestFile(request);
            String response = requestDirector.routeRequestAndGetResponse(requestURI);
            output = new DataOutputStream(clientSocket.getOutputStream());
            output.writeBytes(response);
            output.close();
            input.close();

        } catch (IOException e) {
            System.out.println("Request could not be processed");
            e.printStackTrace();
        }


    }
}
