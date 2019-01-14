package com.wipro.WebCrawler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.junit.Test;

public class PageReaderTest {
	
	@Test
	public void Test_GetRealSite_ShouldReturnRealURI() throws IOException  {
		PageReader pageReader = new PageReader();
		Document document = pageReader.readPage("http://www.google.com");
		System.out.println(document.baseUri());
		assertEquals("http://www.google.com" , document.baseUri());
	}
	
	@Test
	public void Test_GetFakeSite_ShouldReturnNull() throws IOException  {
		PageReader pageReader = new PageReader();
		Document document = pageReader.readPage("http://www.googleccc.com");
		
		assertNull(document);
	}	
	
	
}
