package com.httpserver;

import java.io.IOException;
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
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New thread started on port " + portNumber);

                Runnable serverThread = new ServerThread(clientSocket, requestDirector);
                new Thread(serverThread).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening on port " + portNumber );
            e.printStackTrace();
        }

    }
}