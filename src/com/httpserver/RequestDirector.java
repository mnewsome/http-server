package com.httpserver;

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
        else if (requestURI.equals("/log") || requestURI.equals("/these") || requestURI.equals("/requests"))
            response = new StandardSuccessResponse().generate(requestURI);
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
        else if (requestURI.equals("/form") && requestMethod.equals("GET"))
            response = new StandardSuccessResponse().generate(requestURI);
        else if (requestURI.equals("/form") && requestMethod.equals("POST"))
            response = new PostResponse().generate(request);
        else if (requestURI.equals("/form") && requestMethod.equals("PUT"))
            response = new PutResponse().generate(request);
        else if (requestURI.equals("/redirect"))
            response = new RedirectResponse().generate(requestURI);
        else if (requestURI.equals("/method_options"))
            response = new MethodOptionsResponse().generate(requestURI);
        return response;
    }
}
