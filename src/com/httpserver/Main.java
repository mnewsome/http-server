package com.httpserver;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        int portNumber;

        try {
            portNumber = Integer.parseInt(args[0]);
        } catch (Exception e) {
            portNumber = 5000;
        }

        HttpServer httpServer = new HttpServer(portNumber);
        try {
            httpServer.start();
        } catch (IOException e) {
            System.out.println("Server could not be started.");
            e.printStackTrace();
        }
    }
}
