package com.httpserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

public class FileParser {
    String requestURI;

    public FileParser(String requestFile) {
        this.requestURI = requestFile;
    }

    public String getContentType() {
        String contentType = "";

        if (requestURI.endsWith(".html") || requestURI.endsWith(".htm"))
            contentType = "text/html";
        else if (requestURI.endsWith(".jpg") || requestURI.endsWith(".jpeg"))
            contentType = "image/jpeg";
        else if (requestURI.endsWith(".gif"))
            contentType = "image/gif";
        else if (requestURI.endsWith(".png"))
            contentType = "image/png";
        else
            contentType = "text/plain";

        return contentType;
    }

    public String getContentLength() {
        return String.valueOf(requestURI.length());
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

    public byte[] getFileData(String requestURI) {
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
