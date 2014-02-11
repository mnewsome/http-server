package com.httpserver;

import java.io.FileOutputStream;

public class PutResponse extends ResponseGenerator{
    @Override
    public byte[] generate(String request) {
        String bodyData = new RequestParser().getBodyData(request);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("/Users/mnewsome/cob_spec/public/form");
            fileOutputStream.write(bodyData.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getStatusLine(200).toString().getBytes();
    }
}
