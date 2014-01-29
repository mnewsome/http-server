package com.httpserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server{
    private final int portNumber;

    public Server(int portNumber) {
        this.portNumber = portNumber;
    }

    public void run() {

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader input;
                DataOutputStream output;
                output = new DataOutputStream(clientSocket.getOutputStream());
                input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String request = input.readLine();
                StringTokenizer token = new StringTokenizer(request);
                String method = token.nextToken();
                String fileName = token.nextToken();
                File docRoot = new File(".");

                File requestedFile = new File(docRoot, fileName.substring(1, fileName.length()));
                FileInputStream fileStream = new FileInputStream(requestedFile);
                byte[] fileData = new byte[((int)requestedFile.length())];
                fileStream.read(fileData);
                fileStream.close();

                output.writeBytes("HTTP/1.1 200 OK\r\n");
                output.writeBytes("Content-length: "+ fileData.length + "\r\n");
                output.writeBytes("Content-type: text/html \r\n\r\n");

                output.write(fileData);
                output.close();

                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println(
                    String.format("An error occured while trying to listen on port number %s", portNumber));
            System.out.println(e.getMessage());
        }

    }
}
