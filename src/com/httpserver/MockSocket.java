package com.httpserver;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MockSocket {
    private final String host;
    private final int port;

    public MockSocket(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void openConnection() {
        try {
            Socket clientSocket = new Socket(host, port);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
