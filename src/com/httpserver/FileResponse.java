package com.httpserver;

import java.util.Date;

public class FileResponse extends ResponseGenerator {
    @Override
    public byte[] generate(String requestURI) {
        FileParser fileParser = new FileParser(requestURI);
        String decodedFile = fileParser.getDecodedFile(requestURI);
        Date currentTime = new Date();

        setStatus(200);
        setDate(currentTime);
        setContentType("text/html");

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine());
        responseBuilder.append(getDateHeader());
        responseBuilder.append(getServerInfoHeader());
        responseBuilder.append(getContentType());
        responseBuilder.append("<HTML><BODY>");
        responseBuilder.append(decodedFile);
        responseBuilder.append("</BODY></HTML>");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
      

}
