package com.httpserver;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class ServerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testStartSeverIOError() throws Exception {
        System.out.println("Starting server");

        Server server = new Server(5000);
        server.run();
        thrown.expect(IOException.class);
    }

}
