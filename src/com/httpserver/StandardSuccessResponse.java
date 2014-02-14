package com.httpserver;

public class StandardSuccessResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String requestURI) {
        FileParser fileParser = new FileParser(requestURI);
        String decodedFile = fileParser.getDecodedFile(requestURI);
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(getStatusLine(200));
        responseBuilder.append(getDateHeader());
        responseBuilder.append(getServerInfoHeader());
        responseBuilder.append(getContentType("text/html"));
        responseBuilder.append("<HTML><BODY>");
        responseBuilder.append(decodedFile);
        responseBuilder.append("</BODY></HTML>");
        byte[] response = responseBuilder.toString().getBytes();
        return response;
    }
}
