package com.httpserver;

import java.io.File;

public class DirectoryListingResponse extends ResponseGenerator {
    @Override
    public String generate(String requestURI) {
        System.out.println("inside directory listing: " +requestURI);

        StringBuilder response = new StringBuilder();
        File directory = new File("/Users/mnewsome/cob_spec/public");
        File[] fileListing = directory.listFiles();
        System.out.println("File listing " + fileListing);

        response.append("<HTML><BODY>");
        for (File file : fileListing) {
            response.append(file.getName().toString() + " ");
        }
        response.append("</BODY></HTML>");
        return response.toString();
    }
}
