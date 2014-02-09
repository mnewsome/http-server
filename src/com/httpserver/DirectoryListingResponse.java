package com.httpserver;

import java.io.File;

public class DirectoryListingResponse extends ResponseGenerator {
    @Override
    public byte[] generate(String requestURI) {
        System.out.println("inside directory listing: " +requestURI);

        StringBuilder responseBuilder = new StringBuilder();
        File directory = new File("/Users/mnewsome/cob_spec/public");
        File[] fileListing = directory.listFiles();
        System.out.println("File listing " + fileListing);

        responseBuilder.append("<HTML><BODY>");
        for (File file : fileListing) {
            responseBuilder.append(file.getName().toString() + " ");
        }
        responseBuilder.append("</BODY></HTML>");

        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
