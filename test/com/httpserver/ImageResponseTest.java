package com.httpserver;

import org.junit.Test;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertArrayEquals;

public class ImageResponseTest {

    @Test
    public void testGenerate() throws IOException {
        byte[] testImageResponse = new MockImageResponse().generate("image.gif");
        byte[] response = new ImageResponse().generate("image.gif");
        assertArrayEquals(testImageResponse, response);
    }

    private class MockImageResponse {
        public byte[] generate(String requestURI) {
            Date currentTime = new Date();
            FileParser fileParser = new FileParser(requestURI);
            String response = "HTTP/1.1 200 OK\r\n" +
            "Date: " + currentTime + "\r\n" +
            "Server: Newsome-HTTP-Server\r\n" +
            "Content-type: " + fileParser.getContentLength() + "\r\n\r\n";
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                outputStream.write(response.getBytes());
                outputStream.write(fileParser.getFileData(requestURI));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return outputStream.toByteArray();
        }
    }

    private byte[] getImageData() throws IOException {
        InputStream input = new FileInputStream("image.gif");
        ImageInputStream imageInput = null;
        try {
            imageInput = ImageIO.createImageInputStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage bufferedImage = ImageIO.read(imageInput);
        return bufferedImage.toString().getBytes();
    }

}
