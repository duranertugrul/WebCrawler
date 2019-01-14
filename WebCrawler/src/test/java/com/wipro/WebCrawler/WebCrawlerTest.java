package com.wipro.WebCrawler;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import org.jsoup.Jsoup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class WebCrawlerTest

{

	@Test
	public void Test_CrawlerOneLevel_ShouldReturnFirstPageLinkList() throws IOException, URISyntaxException {
		String rootURL = "https://www.google.com";
		PageReader reader = Mockito.mock(PageReader.class);
		Mockito.when(reader.readPage(Mockito.anyString())).thenReturn(Jsoup.parseBodyFragment("<html><head></head><body>" + "<a href='http://www.google.com'>"
						+ "<a href='http://www.google.com/deneme.html'>" + "</body></html>"));

		
		WebCrawler webCrawler = new WebCrawler(reader);
		Set<String> urls = webCrawler.startCrawling(rootURL, 1);

		assertTrue(urls.contains("http://www.google.com"));
		assertTrue(urls.contains("http://www.google.com/deneme.html"));
	}
	
	@Test
	public void Test_CrawlerTwoLevel_ShouldReturnAllLinkList() throws IOException, URISyntaxException {
		String rootURL = "https://www.google.com";
		PageReader reader = Mockito.mock(PageReader.class);
		Mockito.when(reader.readPage(Mockito.anyString())).thenReturn(Jsoup.parseBodyFragment("<html><head></head><body>" + "<a href='http://www.google.com'>"
						+ " <a href='http://www.google.com/deneme.html'>" + "</body></html>")).thenReturn(Jsoup.parseBodyFragment("<html><head></head><body>" 
								+ "<a href='http://www.google.com/contact.html'>"
								+ "<a href='http://www.google.com/aboutus.html'>" + "</body></html>"));

		
		WebCrawler webCrawler = new WebCrawler(reader);
		Set<String> urls = webCrawler.startCrawling(rootURL, 2);

		assertTrue(urls.contains("http://www.google.com"));
		assertTrue(urls.contains("http://www.google.com/deneme.html"));
		assertTrue(urls.contains("http://www.google.com/contact.html"));
		assertTrue(urls.contains("http://www.google.com/aboutus.html"));
	}	
	

	 
}
