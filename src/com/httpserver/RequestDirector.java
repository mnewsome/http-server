package com.httpserver;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.io.*;

public class RequestDirector {

    public byte[] routeRequestAndGetResponse(String request) {
        byte[] response = new byte[0];
        RequestParser requestParser = new RequestParser();
        String requestURI = requestParser.getRequestURI(request);
        String requestMethod = requestParser.getRequestMethod(request);

        if (requestURI.equals("/logs") && requestMethod.equals("GET") && requestParser.requestHeaderContains(request, "Authorization: Basic YWRtaW46aHVudGVyMg=="))
            return response = new BasicAuthResponseWithCredentials().generate(requestURI);
        else if (requestURI.equals("/logs") && requestMethod.equals("GET"))
            response = new BasicAuthResponse().generate(requestURI);
        else if (requestURI.equals("/"))
            response = new RootResponse().generate(requestURI);
        else if (requestURI.equals("/file1") && requestMethod.equals("GET"))
            response = new FileResponse().generate(requestURI);
        else if (requestURI.equals("/foobar"))
            response = new FileDoesNotExistResponse().generate(requestURI);
        else if (requestURI.equals("/image.jpeg") || requestURI.equals("/image.gif") || requestURI.equals("/image.png"))
            response = new ImageResponse().generate(requestURI);
        else if (requestURI.equals("/file1") && requestMethod.equals("PUT"))
            response = new MethodNotAllowedResponse().generate(requestURI);
        else if (requestURI.equals("/text-file.txt") && requestMethod.equals("POST"))
            response = new MethodNotAllowedResponse().generate(requestURI);
        else if (requestURI.contains("/parameters?"))
            response = new ParameterDecodeResponse().generate(requestURI);
        else if (requestURI.equals("/partial_content.txt"))
            response = new PartialContentResponse().generate(requestURI);
        else if (requestURI.equals("/form"))
            response = new StandardSuccessResponse().generate(requestURI);
        else if (requestURI.equals("/redirect"))
            response = new RedirectResponse().generate(requestURI);
        else if (requestURI.equals("/method_options"))
            response = new MethodOptionsResponse().generate(requestURI);
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
