package com.wipro.WebCrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {

	private PageReader reader;
	Set<String> pageLinks = new HashSet<>();
	Set<String> visitedLinks= new HashSet<>();
	
	private String mainUrlDomainName; 

	public WebCrawler(PageReader reader) {
		this.reader = reader;

	}

	public Set<String> startCrawling(String rootURL, int searchLevel) throws IOException, URISyntaxException  {
		
		Set<String> searchList = new HashSet<>();
		searchList.add(rootURL);
		mainUrlDomainName = DomainInfo.getDomainName(rootURL);
		visitAndSearchDocument(searchList, searchLevel);
		
		return pageLinks;
	}
	
	private void visitAndSearchDocument(Set<String> toBeVisitedList, int searchLevel) throws IOException, URISyntaxException{
		if (searchLevel <= 0)
			return;
		searchLevel --;
		
		for (String urlLink : toBeVisitedList) {

			if (!shouldVisit(urlLink))
				continue;
			
			Document document = reader.readPage(urlLink);
			Set<String> resultList = findMatchedURLList(document);
			visitedLinks.add(urlLink);
			pageLinks.addAll(resultList);
			
			
			visitAndSearchDocument(resultList, searchLevel); 
		}
	}
	
	private boolean shouldVisit(String urlLink) throws MalformedURLException, URISyntaxException {
		boolean isDifferentDomainName = !DomainInfo.isTheSameDomainName(mainUrlDomainName, urlLink);
		boolean isLinkVisited = (visitedLinks.stream().filter(s-> s.equals(urlLink)).collect(Collectors.toList()).size() > 0); 


		return !(isDifferentDomainName || isLinkVisited);
			
	}	
	
	
	
	private Set<String> findMatchedURLList(Document document){
		Elements linksOnPage = document.select("a[href]");
		Set<String> resultList = new HashSet<>();
		
        for(Element link : linksOnPage)
        {
        	if (link.absUrl("href").indexOf("mailto:")>= 0)
        		continue;
        	resultList.add(link.absUrl("href"));
        }
        return resultList;
	}
}
