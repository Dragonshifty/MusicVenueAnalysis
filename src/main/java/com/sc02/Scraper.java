package com.sc02;
import org.jsoup.*; 
import org.jsoup.nodes.*; 
import java.io.*;


public class Scraper {
    public Document scrapePage (String url){
        Document doc = new Document(null);
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
