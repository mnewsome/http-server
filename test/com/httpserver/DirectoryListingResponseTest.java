package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectoryListingResponseTest {

    @Test
    public void testGenerate() {
        String testDirectoryListing = new MockDirectoryListingResponse().generate("/");
        byte[] directoryListing = new DirectoryListingResponse().generate("/Users/mnewsome/Public/");
        assertEquals("Directory Listing Response", testDirectoryListing, directoryListing);
    }

    private class MockDirectoryListingResponse {
        public String generate(String requestURI) {
            String response = ".com.apple.timemachine.supported .localized Drop Box favicon.ico index.html ";
            return response;
        }
    }
}
