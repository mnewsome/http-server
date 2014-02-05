package com.httpserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectoryListingResponseTest {

    @Test
    public void testGenerate() {
        String testDirectoryListing = new MockDirectoryListingResponse().generate("/");
        String directoryListing = new DirectoryListingResponse().generate("/Users/mnewsome/Public/");
        assertEquals("Directory Listing Response", testDirectoryListing, directoryListing);
    }
}
