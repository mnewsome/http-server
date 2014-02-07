package com.httpserver;

import java.util.Date;

public class PartialContentResponse extends ResponseGenerator {
    @Override
    public String generate(String requestURI) {
        FileParser fileParser = new FileParser(requestURI);
        String decodedFile = fileParser.getDecodedFile(requestURI);
        Date currentDateTime = new Date();
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 206 Partial Content\r\n");
        response.append("Date: " + currentDateTime + "\r\n");
        response.append("Server: Newsome-HTTP-Server\r\n");
        response.append("Content-length: " + fileParser.getContentLength() + "\r\n");
        response.append("Range: bytes=0-4\r\n");
        response.append("Content-type: " + fileParser.getContentType() + "\r\n\r\n");
        response.append(decodedFile.substring(0,4));

        return response.toString();
    }

}
