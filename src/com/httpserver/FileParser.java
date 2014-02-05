package com.httpserver;

import java.io.File;

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
}
