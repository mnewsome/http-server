package com.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private final int portNumber;
    private final RequestDirector requestDirector;

    public HttpServer(int portNumber, RequestDirector requestDirector) {
        this.portNumber = portNumber;
        this.requestDirector = requestDirector;
    }

    public void start() throws IOException{
        Socket clientSocket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                clientSocket = serverSocket.accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("New thread started on port " + portNumber);

                new ServerThread(clientSocket, requestDirector,input).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening on port " + portNumber );
            e.printStackTrace();
        }

    }
}