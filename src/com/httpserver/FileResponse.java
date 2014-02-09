package com.httpserver;

import java.util.Date;

public class FileResponse extends ResponseGenerator {
    @Override
    public byte[] generate(String requestURI) {
        FileParser fileParser = new FileParser(requestURI);
        String decodedFile = fileParser.getDecodedFile(requestURI);
        Date currentDateTime = new Date();
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("HTTP/1.1 200 OK\r\n");
        responseBuilder.append("Date: " + currentDateTime + "\r\n");
        responseBuilder.append("Server: Newsome-HTTP-Server\r\n");
        responseBuilder.append("Content-type: text/html\r\n\r\n");
        responseBuilder.append("<HTML><BODY>");
        responseBuilder.append(decodedFile);
        responseBuilder.append("</BODY></HTML>");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
      

}
