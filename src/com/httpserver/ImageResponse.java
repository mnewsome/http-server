package com.httpserver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

public class ImageResponse extends ResponseGenerator {
    @Override
    public byte[] generate(String requestURI) {
        Date currentDateTime = new Date();
        FileParser fileParser = new FileParser(requestURI);
        byte[] imageFile = fileParser.getFileData(requestURI);
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine(200));
        responseBuilder.append(getDateHeader());
        responseBuilder.append(getServerInfoHeader());
        responseBuilder.append(getContentType(fileParser.getContentType()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            outputStream.write(responseBuilder.toString().getBytes());
            outputStream.write(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

}
