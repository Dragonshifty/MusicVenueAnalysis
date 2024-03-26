package com.sc02;
import org.jsoup.*; 
import org.jsoup.nodes.*; 
import org.jsoup.select.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ScrapeAndBake {
    VenueURLs venueURLs = new VenueURLs();
    Scraper scraper = new Scraper();
    ExtractElements extractElements = new ExtractElements();
    JsonConverter jsonConverter = new JsonConverter();

    public void makeItSo(){
        Map<String, String> venues = venueURLs.getVenueURLs();

        Document doc = scraper.scrapePage(venues.get("O2 Academy Bristol"));

        List<Artist> artistList = extractElements.Extract(doc);

        jsonConverter.processToMap(artistList);
    }
}
