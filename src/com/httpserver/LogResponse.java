package com.httpserver;

import java.io.FileOutputStream;

public class LogResponse extends ResponseGenerator {
    @Override
    public byte[] generate(String request) {
        String headerLine = new RequestParser().getHeaderLine(request);
        String formattedHeader = headerLine + "\r\n";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("/Users/mnewsome/cob_spec/public/logs", true);
            fileOutputStream.write(formattedHeader.getBytes());
        } catch (Exception e) {
            System.out.println("Log could not be created.");
        }
        return getStatusLine(200).getBytes();
    }
}
