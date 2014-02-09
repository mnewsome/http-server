package com.httpserver;

import java.util.Date;

public class PartialContentResponse extends ResponseGenerator {
    @Override
    public byte[] generate(String requestURI) {
        FileParser fileParser = new FileParser(requestURI);
        String decodedFile = fileParser.getDecodedFile(requestURI);
        Date currentDateTime = new Date();
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("HTTP/1.1 206 Partial Content\r\n");
        responseBuilder.append("Date: " + currentDateTime + "\r\n");
        responseBuilder.append("Server: Newsome-HTTP-Server\r\n");
        responseBuilder.append("Content-type: text/plain\r\n\r\n");
        responseBuilder.append(decodedFile.substring(0, 4));
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }

}
