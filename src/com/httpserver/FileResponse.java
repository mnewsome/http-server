package com.httpserver;

import java.util.Date;

public class FileResponse extends ResponseGenerator {
    @Override
    public byte[] generate(String requestURI) {
        FileParser fileParser = new FileParser(requestURI);
        String decodedFile = fileParser.getDecodedFile(requestURI);
        Date currentTime = new Date();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine(200));
        responseBuilder.append(getDateHeader());
        responseBuilder.append(getServerInfoHeader());
        responseBuilder.append(getContentType("text/html"));
        responseBuilder.append("<HTML><BODY>");
        responseBuilder.append(decodedFile);
        responseBuilder.append("</BODY></HTML>");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
      

}
