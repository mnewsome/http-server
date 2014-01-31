package com.httpserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

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
            RequestDirector requestDirector = new RequestDirector(input);
            String requestLine = requestDirector.getRequest();
            System.out.println(requestLine);
            ResponseGenerator responseGenerator = new ResponseGenerator(requestDirector.getRequestFile(requestLine));
            output = new DataOutputStream(clientSocket.getOutputStream());
            System.out.println(responseGenerator.rootResponse());

            output.writeBytes("HTTP/1.1 200 OK\r\n");
            Date currentDateTime = new Date();
            output.writeBytes("Date: " + currentDateTime + "\r\n");
            output.writeBytes("Server: Newsome-HTTP-Server\r\n");
            output.writeBytes("Content-type: text/plain\r\n");
            output.writeBytes("Content-length: 60\r\n\r\n");
//            output.writeBytes(responseGenerator.rootResponse());

        } catch (IOException e) {
            System.out.println("Request could not be processed");
            e.printStackTrace();
        }


    }
}
