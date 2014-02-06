package com.httpserver;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        int portNumber = 5000;
        String rootDirectory = "/Users/mnewsome/cob_spec/public";


        RequestDirector requestDirector = new RequestDirector();

        HttpServer httpServer = new HttpServer(portNumber, requestDirector);
        try {
            httpServer.start();
        } catch (IOException e) {
            System.out.println("Server could not be started.");
            e.printStackTrace();
        }
    }

    private static int getPortNumber(String arg) {
        int portNumber;
        try {
            portNumber = Integer.parseInt(arg);
        } catch (Exception e) {
            portNumber = 5000;
        }
        return portNumber;
    }
}
