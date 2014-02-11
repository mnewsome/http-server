package com.httpserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread {
    private final Socket clientSocket;
    private final RequestDirector requestDirector;
    private BufferedReader input;

    public ServerThread(Socket clientSocket, RequestDirector requestDirector, BufferedReader input) {
        this.clientSocket = clientSocket;
        this.requestDirector = requestDirector;
        this.input = input;
    }

    public void run() {
        DataOutputStream output;

        try {

            RequestParser requestParser = new RequestParser();
            String request = requestParser.getRequest(input);
            byte[] response = requestDirector.routeRequestAndGetResponse(request);
            output = new DataOutputStream(clientSocket.getOutputStream());
            output.write(response);
            output.close();
            input.close();
            clientSocket.close();

        } catch (IOException e) {
            System.out.println("Request could not be processed");
            e.printStackTrace();
        }


    }
}
