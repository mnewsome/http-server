package com.httpserver;

import java.io.File;

public class DirectoryListingResponse extends ResponseGenerator {
    @Override
    public String generate(String requestURI) {

        StringBuilder response = new StringBuilder();
        File directory = new File(requestURI);
        File[] fileListing = directory.listFiles();

        response.append("<HTML><BODY>");
        for (File file : fileListing) {
            response.append(file.getName().toString() + " ");
        }
        response.append("</BODY></HTML>");
        return response.toString();
    }
}
