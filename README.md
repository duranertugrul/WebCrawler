# Web Crawler
A Java based web crawler to get a list of link from the web pages in desired level.


## Compatability

This program is developed with Java8 . It is a download-and-run program with couple of changes according if required by the user.


### Dependencies There are two dependencies . They are org.jsoup and com.google.guava.By means of com.google.guava, I get domain name and By means of org.jsoup I get the documents.


#### Status
This is a small java application which is ready-to-run.

##### Usage
As mentioned, it is a ready-to-run application. You can see the usege in below.

```
PageReader reader = new PageReader();
WebCrawler webCrawler = new WebCrawler(reader);
int searchLevel = 2;
Set<String> urls = webCrawler.startCrawling(rootURL, searchLevel);
```

