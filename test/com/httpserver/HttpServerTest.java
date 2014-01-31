package com.httpserver;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class HttpServerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testStartSeverIOError() throws Exception {
        System.out.println("Starting httpServer");

        HttpServer httpServer = new HttpServer(5000);
        httpServer.start();
        thrown.expect(IOException.class);
    }

}
