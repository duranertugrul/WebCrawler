package com.wipro.WebCrawler;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import org.junit.Test;


public class DomainInfoTest {
	
	@Test
	public void Test_CheckDomainName_BasicLink() throws MalformedURLException {
		String name = DomainInfo.getDomainName("http://www.google.com");
		assertEquals("google.com" , name);
	}
	
	@Test
	public void Test_CheckDomainName_ComplexLink() throws MalformedURLException {
		String name = DomainInfo.getDomainName("http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2F2018%2F11%2F20%2Fthe-meaning-of-motion%2F&title=The meaning of motion&summary=https%3A%2F%2Fwiprodigital.com%2F2018%2F11%2F20%2Fthe-meaning-of-motion%2F&source=wiprodigital.com");
		assertEquals("linkedin.com" , name);
	}	
	
	
}
