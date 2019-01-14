Web Crawler
A Java based web crawler to get a list of link from the web pages in desired level.


Compatability
This program is developed with Java8 . It is a download-and-run program with couple of changes according if required by the user.


##Dependencies There are two dependencies . They are org.jsoup and com.google.guava.By means of com.google.guava, I get domain name and By means of org.jsoup I get the documents.


Status
This is a small java application which is ready-to-run.

Usage
As mentioned, it is a ready-to-run application. You can see the usege in below.
	PageReader reader = new PageReader();
	WebCrawler webCrawler = new WebCrawler(reader);
	int searchLevel = 2;
	Set<String> urls = webCrawler.startCrawling(rootURL, searchLevel);

Disclaimer
This program lets you download and crawl tons of web pages. Please do not download and crawl any pages of a domain without reading about the robot.txt file of that domain. It is inappropriate to violate the robot.txt file. This may even lead to the domain completely blocking your crawler and thus blacklisting it. It is also not appropriate to crawl pages at high rate as it may put a lot of pressure on the server.
