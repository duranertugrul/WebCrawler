package com.wipro.WebCrawler;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.common.net.InternetDomainName;

public class DomainInfo {

	
	public static String getDomainName(String urlString) throws MalformedURLException {

		final URL url = new URL(urlString);
		final String host = url.getHost();

		final InternetDomainName name = InternetDomainName.from(host).topPrivateDomain();
		return name.toString();

	}

	public static boolean isTheSameDomainName(String mainDomain, String url) throws URISyntaxException, MalformedURLException {

		return mainDomain.equals(getDomainName(url));
	}
}
