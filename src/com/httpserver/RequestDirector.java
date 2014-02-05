package com.httpserver;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.io.*;

public class RequestDirector {

    public String routeRequestAndGetResponse(String request) {
        String response = "";
        String requestURI = new RequestParser().getRequestURI(request);

        if (requestURI.equals("/"))
            response = new RootResponse().generate(requestURI);
        else if (requestURI.equals("/logs"))
            response = new BasicAuthResponse().generate(requestURI);
        else if (requestURI.equals("/method_options"))
            response = new MethodOptionsResponse().generate(requestURI);
        else if (requestURI.equals("/file1"))
            response = new MethodNotAllowedResponse().generate(requestURI);
        else if (requestURI.equals("/text-file.txt") || requestURI.equals("/file1"))
            response = new MethodNotAllowedResponse().generate(requestURI);
        else if (requestURI.equals("/form"))
            response = new StandardSuccessResponse().generate(requestURI);
        else if (requestURI.contains("/parameters?"))
            response = new ParameterDecodeResponse().generate(requestURI);
        else if (requestURI.equals("/partial_content.txt"))
            response = new PartialContentResponse().generate(requestURI);
        else if (requestURI.equals("/redirect"))
            response = new RedirectResponse().generate(requestURI);
        else if (isDirectory(requestURI))
            response = new DirectoryListingResponse().generate(requestURI);
        else if (fileExists(requestURI))
            response = new FileResponse().generate(requestURI.replace("/", ""));
        else if (!fileExists(requestURI))
            response = new FileDoesNotExistResponse().generate(requestURI);

        System.out.println(response);
        return response;

    }

    private Boolean fileExists (String requestURI) {
        Boolean fileExists;
        if (isFileFound(requestURI))
            fileExists = true;
        else if (isImageFound(requestURI))
            fileExists = true;
        else
            fileExists = false;
        return fileExists;
    }

    private Boolean isDirectory (String requestURI) {
        if (requestURI.endsWith("/")) return true;
        else return false;
    }

    private Boolean isFileFound(String requestURI) {
        Boolean fileExists = true;
        try {
            File file = new File(requestURI.substring(1, requestURI.length()));
            FileInputStream fileStream = new FileInputStream(file);
            byte[] fileData = new byte[((int)requestURI.length())];
            fileStream.read(fileData);
            fileStream.close();
        } catch (Exception e) {
            fileExists = false;
        }
        return fileExists;
    }

    private Boolean isImageFound(String requestURI) {
        Boolean imageExists = true;
        try {
            InputStream inputStream = new FileInputStream(requestURI);
            ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);
            ImageIO.read(inputStream);

        } catch (Exception e) {
            imageExists = false;
        }
        return imageExists;

    }
}
