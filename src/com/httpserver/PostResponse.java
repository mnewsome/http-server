package com.httpserver;

import java.io.FileOutputStream;

public class PostResponse extends ResponseGenerator {
    public byte[] generate(String request) {
        String bodyData = new RequestParser().getBodyData(request);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("/Users/mnewsome/cob_spec/public/form");
            outputStream.write(bodyData.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getStatusLine(200).toString().getBytes();
    }
}
