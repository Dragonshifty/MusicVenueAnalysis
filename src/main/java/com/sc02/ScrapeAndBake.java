package com.sc02;
import org.jsoup.nodes.*; 
import java.util.List;
import java.util.Map;

public class ScrapeAndBake {
    VenueURLs venueURLs = new VenueURLs();
    Scraper scraper = new Scraper();
    ExtractElements extractElements = new ExtractElements();
    JsonConverter jsonConverter = new JsonConverter();
    CSVConverter csvConverter = new CSVConverter();
    HTMLConverter htmlConverter = new HTMLConverter();

    public void makeItSo(){
        // Not to be run all at once - comment out as needed to run each section
        convertToHtml(); // Run  first
        convertToCSV(); // Run second
        csvConverter.joinCSVs(); // Run second
        csvConverter.CSVComparitor(); // Run Third with filenames inserted
    }

    private void convertToHtml(){
        Map<String, String> venues = venueURLs.getVenueURLs();
        List<String> venueList = venueURLs.getVenueList();

        try {
            for (String venue : venueList){
                Document doc = scraper.scrapePage(venues.get(venue));
                htmlConverter.convertToHTML(doc, venue);
                Thread.sleep(5000); // Delay so as not to upset the server
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }  
        System.out.println("Got all HTML components");
    }

    private void convertToCSV(){
        List<String> venueList = venueURLs.getVenueList();

        for (String venue : venueList){
            Document doc = htmlConverter.loadDocFromHTML(venue);
            List<Artist> artistList = extractElements.Extract(doc);
            csvConverter.convertToCSV(artistList, venue);
        }
        System.out.println("Converted all CSVs");
    }
}
