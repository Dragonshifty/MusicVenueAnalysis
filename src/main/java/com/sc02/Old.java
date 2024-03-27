package com.sc02;
import org.jsoup.*; 
import org.jsoup.nodes.*; 
import org.jsoup.select.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;

public class Old {
    public static void old( String[] args )
    {
        // scrape();
        // read();
        // scrapeAndSaveHTML();
        // loadAndProcessHTML();

        VenueURLs venueURLs = new VenueURLs();
        VenueCapacityValues venueCapacityValues = new VenueCapacityValues();

        Map<String, String> venues = venueURLs.getVenueURLs();
        Map<String, Integer> capacities = venueCapacityValues.getVenueCapacityValues();
        
        System.out.println(venues.get("O2 Academy Birmingham"));
        System.out.println(capacities.get("O2 Academy Birmingham"));

    }

    private static void scrape(){

        try {
            Document doc = Jsoup.connect("https://www.academymusicgroup.com/o2apollomanchester/events/all").get();

            serializeDocument(doc, "serialized_document2.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Document docRead = new Document(null);
        // try{
        //     docRead = Jsoup.connect("https://www.academymusicgroup.com/o2apollomanchester/events/all").get();
        // } catch (IOException e){
        //     e.printStackTrace();
        // }

        // Elements titles = docRead.select("h3");

        // List<String> titesList = new ArrayList<String>();
        // for (Element elementO : titles)
        // {
        //     Element h3Element = elementO.selectFirst("h3.m0");
        //     if (h3Element != null) {
        //         String text = h3Element.text();
        //         titesList.add(text);
        //     }
        // }

        // for (String line : titesList){
        //     System.out.println(line);
        // }

        // Element element = docRead.selectFirst("h3.m0");
        // if (element != null) {
        //     System.out.println(element.text());
        // } else {
        //     System.out.println("Element not found");
        // }

        // System.out.println(element.text());
    }

    public void makeItSo(){

        // convertToHtml();

        // convertToCSV();

        

        // Map<String, String> venues = venueURLs.getVenueURLs();

        // Document doc = scraper.scrapePage(venues.get("O2 Academy Edinburgh"));
        

        // htmlConverter.convertToHTML(doc, "O2 Academy Edinburgh");
        // Document doc = htmlConverter.loadDocFromHTML("O2 Academy Edinburgh");
        // List<Artist> artistList = extractElements.Extract(doc);

        // jsonConverter.processToMap(artistList);
        // csvConverter.convertToCSV(artistList, "O2 Academy Edinburgh");
        
    }

    private static void read(){
        Document docRead = new Document(null);
        try{
            docRead = deserializeDocument("serialized_document.ser");
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        Elements titles = docRead.select("h3");

        List<String> titesList = new ArrayList<String>();
        for (Element elementO : titles)
        {
            Element h3Element = elementO.selectFirst("h3.m0");
            if (h3Element != null) {
                String text = h3Element.text();
                titesList.add(text);
            }
        }

        for (String line : titesList){
            System.out.println(line);
        }
    }

    private static void serializeDocument(Document doc, String filename) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(doc);
        }
    }

    private static Document deserializeDocument(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (Document) in.readObject();
        }
    }

    private static void scrapeAndSaveHTML() {
        try {
            Document doc = Jsoup.connect("https://www.academymusicgroup.com/o2apollomanchester/events/all").get();
            saveHTMLToFile(doc, "scraped_html.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveHTMLToFile(Document doc, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(doc.outerHtml());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadAndProcessHTML() {
        Document loadedDoc = new Document(null);
        try {
            loadedDoc = Jsoup.parse(new File("scraped_html.html"), "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }



        Elements eventArticles = loadedDoc.select("article.node-event-calendar");

        List<Artist> artistList = new ArrayList<>();

        for (Element eventElement : eventArticles){
            String artist = eventElement.selectFirst("h3.m0 a").text();
            String venue = eventElement.selectFirst(".field-item").text();
            String day = eventElement.selectFirst(".day").text();
            String date = eventElement.selectFirst(".date").text();
            String time = eventElement.selectFirst(".time").text();
            String status = eventElement.selectFirst(".ticket-status").text();

            Artist performer = new Artist(artist, venue, day, date, time);
            artistList.add(performer);
    }
        System.out.println(artistList.size());
        for (Artist arr : artistList){
            System.out.println(arr);
        }
        // Elements titles = loadedDoc.select("h3");

        // List<String> titesList = new ArrayList<String>();
        // for (Element elementO : titles)
        // {
        //     Element h3Element = elementO.selectFirst("h3.m0");
        //     if (h3Element != null) {
        //         String text = h3Element.text();
        //         titesList.add(text);
        //     }
        // }

        // for (String line : titesList){
        //     System.out.println(line);
        // }
        
    }
}
