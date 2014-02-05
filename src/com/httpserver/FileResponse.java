package com.httpserver;

import java.io.*;
import java.util.Date;

public class FileResponse extends ResponseGenerator {
    @Override
    public String generate(String requestURI) {
        String decodedFile = getDecodedFile(requestURI);
        FileParser fileParser = new FileParser(requestURI);
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
      
    private String getDecodedFile(String requestURI) {
        String decodedFile = "";
        try {
            decodedFile = new String(getFileData(requestURI), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodedFile;
    }

    private byte[] getFileData(String requestURI) {
        File requestedFile = new File(requestURI);
        byte[] fileData = new byte[(int)requestedFile.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(requestedFile);
            fileInputStream.read(fileData);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileData;
    }
}
