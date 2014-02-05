package com.httpserver;

import java.util.Date;

public class FileResponse extends ResponseGenerator {
    @Override
    public String generate(String requestURI) {
        FileParser fileParser = new FileParser(requestURI);
        String decodedFile = fileParser.getDecodedFile(requestURI);
        Date currentDateTime = new Date();
        StringBuilder response = new StringBuilder();
            response.append("HTTP/1.1 200 OK\r\n");
            response.append("Date: " + currentDateTime + "\r\n");
            response.append("Server: Newsome-HTTP-Server\r\n");
            response.append("Content-length: " + fileParser.getContentLength() + "\r\n");
            response.append("Content-type: " + fileParser.getContentType() + "\r\n\r\n");
            response.append(decodedFile);

        return response.toString();
    }
      

}
