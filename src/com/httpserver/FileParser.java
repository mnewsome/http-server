package com.httpserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

public class FileParser {
    String requestFile;

    public FileParser(String requestFile) {
        this.requestFile = requestFile;
    }

    public String getContentType() {
        String contentType = "";

        if (requestFile.endsWith(".html") || requestFile.endsWith(".htm"))
            contentType = "text/html";
        else if (requestFile.endsWith(".jpg") || requestFile.endsWith(".jpeg"))
            contentType = "image/jpeg";
        else if (requestFile.endsWith(".gif"))
            contentType = "image/gif";
        else if (requestFile.endsWith(".png"))
            contentType = "image/png";
        else
            contentType = "text/plain";

        return contentType;
    }

    public String getContentLength() {
        return String.valueOf(requestFile.length());
    }

    public String getDecodedFile(String requestURI) {
        String decodedFile = "";
        try {
            decodedFile = new String(getFileData(requestURI), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodedFile;
    }

    private byte[] getFileData(String requestURI) {
        File requestedFile = getRequestedFile(requestURI);

        byte[] fileData = new byte[(int)requestedFile.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(requestedFile);
            fileInputStream.read(fileData);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileData;
    }

    private File getRequestedFile(String requestURI) {
        File requestedFile;
        if (requestURI.startsWith("/"))
            requestedFile = new File("/Users/mnewsome/cob_spec/public",requestURI.substring(1, requestURI.length()));
        else
            requestedFile = new File(requestURI);

        return requestedFile;
    }
}
