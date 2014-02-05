package com.httpserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

public class FileParser {
    String requestFile;
    File root;

    public FileParser(String requestFile) {
        this.requestFile = requestFile;
    }

    public File rootDirectory() {
        try {
            root = new File(requestFile);
        } catch (Exception e) {
            root = new File(".");
        }
        return root;
    }

    public boolean isDirectory() {
        return requestFile.endsWith("/");
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

    public boolean isImage() {
        if (requestFile.endsWith(".jpeg") || requestFile.endsWith(".png") || requestFile.endsWith(".gif")) return  true;
        else return false;
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
        File requestedFile = new File(requestURI.substring(1, requestURI.length()));
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
