package com.httpserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class RequestDirector {

    public String getRequest(BufferedReader clientInput) throws IOException {
        StringBuilder request = new StringBuilder();
        while (clientInput.ready()) {
            request.append((char) clientInput.read());
        }
        return request.toString();
    }

    public String getRequestMethod(String request) {
        String[] headerLineParts = getHeaderLineParts(request);
        String requestMethod = headerLineParts[0];
        return requestMethod;
    }

    public String getRequestFile(String request) {
        String[] headerLineParts = getHeaderLineParts(request);
        String fileName = headerLineParts[1];
        return fileName;
    }

    private String[] getHeaderLineParts(String request) {
        String[] headerLine = request.split("\r\n");
        String[] headerLineParts = headerLine[0].split(" ");
        return headerLineParts;
    }


    public String routeRequestAndGetResponse(String requestURI) {
        String response = "";

//        if (requestURI.equals("/"))
//            response = new RootResponse().generate(requestURI);
        if (isDirectory(requestURI))
            response = new DirectoryListingResponse().generate(requestURI);
        else if (fileExists(requestURI))
            response = new FileResponse().generate(requestURI.replace("/", ""));
        else if (!fileExists(requestURI))
            response = new FileDoesNotExist().generate(requestURI);

        return response;

    }

    private Boolean fileExists (String requestURI) {
        Boolean fileExists = true;

        try {
            File file = new File(requestURI.substring(1, requestURI.length()));
            FileInputStream fileStream = new FileInputStream(file);
            FileParser fileParser = new FileParser(requestURI);
            byte[] fileData = new byte[((int)requestURI.length())];
            fileStream.read(fileData);
            fileStream.close();
        } catch (Exception e) {
            fileExists = false;
        }

        return fileExists;
    }

    private Boolean isDirectory (String requestURI) {
        if (requestURI.endsWith("/")) return true;
        else return false;
    }
}
