package com.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private final int portNumber;

    public HttpServer(int portNumber) {
        this.portNumber = portNumber;

    }

    public void start() throws IOException{
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Server listening on port " + portNumber);

            ServerThread serverThread = new ServerThread("public", clientSocket);
            serverThread.run();

        } catch (IOException e) {
            System.out.println("Error occurred while listening on port " + portNumber );
            e.printStackTrace();
        }

    }
}