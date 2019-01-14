package com.wipro.WebCrawler;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PageReader {
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

	public Document readPage(String url) {

		Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
		Document htmlDocument = null;
		try {
			htmlDocument = connection.get();
			
			if (connection.response().statusCode() == 200) // 200 is the HTTP OK status code
			{
				System.out.println("\n**Visiting** Received web page at " + url);
			}
			else if (!connection.response().contentType().contains("text/html")) {
				System.out.println("**Failure** Retrieved something other than HTML");
				return null;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return htmlDocument;
	}

}
