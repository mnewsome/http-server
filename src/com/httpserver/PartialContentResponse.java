package com.httpserver;

import java.util.Date;

public class PartialContentResponse extends ResponseGenerator {
    @Override
    public byte[] generate(String requestURI) {
        FileParser fileParser = new FileParser(requestURI);
        String decodedFile = fileParser.getDecodedFile(requestURI);
        Date currentDateTime = new Date();
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine(206));
        responseBuilder.append(getDateHeader());
        responseBuilder.append(getServerInfoHeader());
        responseBuilder.append(getContentType(fileParser.getContentType()));
        responseBuilder.append(decodedFile.substring(0, 4));
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }

}
