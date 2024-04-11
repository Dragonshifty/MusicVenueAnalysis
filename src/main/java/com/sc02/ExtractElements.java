package com.sc02;
import org.jsoup.nodes.*; 
import org.jsoup.select.*;
import java.util.ArrayList;
import java.util.List;

public class ExtractElements {
    public List<Artist> Extract(Document loadedDoc){
        
        Elements eventArticles = loadedDoc.select("article.node-event-calendar");

        List<Artist> artistList = new ArrayList<>();

        for (Element eventElement : eventArticles){
            String artist = eventElement.selectFirst("h3.m0 a").text();
            String venue = eventElement.selectFirst(".field-name-field-event-location .field-item.even").text();
            String day = eventElement.selectFirst(".day").text();
            String date = eventElement.selectFirst(".date").text();
            String time = eventElement.selectFirst(".time").text();
            Artist performer = new Artist(artist, venue, day, date, time);
            artistList.add(performer);
        }
        return artistList;
    }
}
