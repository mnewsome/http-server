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
        RequestDirector requestDirector = new RequestDirector();
        HttpServer httpServer = new HttpServer(5000, requestDirector);
        httpServer.start();
        thrown.expect(IOException.class);
    }

}
