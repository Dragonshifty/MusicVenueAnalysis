package com.sc02;
import org.jsoup.*; 
import org.jsoup.nodes.*; 
import org.jsoup.select.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExtractElements {
    public List<Artist> Extract(Document loadedDoc){
        
        Elements eventArticles = loadedDoc.select("article.node-event-calendar");

        List<Artist> artistList = new ArrayList<>();

        for (Element eventElement : eventArticles){
            String artist = eventElement.selectFirst("h3.m0 a").text();
            String venue = eventElement.selectFirst(".field-item").text();
            String day = eventElement.selectFirst(".day").text();
            String date = eventElement.selectFirst(".date").text();
            String time = eventElement.selectFirst(".time").text();
            String status = eventElement.selectFirst(".ticket-status").text();

            Artist performer = new Artist(artist, venue, day, date, time, status);
            artistList.add(performer);
        }
        return artistList;
    }
}
