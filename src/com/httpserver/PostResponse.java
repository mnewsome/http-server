package com.httpserver;

import java.io.FileOutputStream;

public class PostResponse extends ResponseGenerator {
    public byte[] generate(String request) {
        String bodyData = new RequestParser().getBodyData(request);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("/Users/mnewsome/cob_spec/public/form");
            fileOutputStream.write(bodyData.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getStatusLine(200).toString().getBytes();
    }
}
