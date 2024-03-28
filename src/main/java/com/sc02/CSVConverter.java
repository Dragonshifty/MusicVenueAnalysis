package com.sc02;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.List;

public class CSVConverter {
    private final String currentMonth = "April";
    private String joinedCSVFileName = "O2 Venues Full Data.csv";
    private VenueCapacityValues venueCapacityValues = new VenueCapacityValues();

    public void convertToCSV(List<Artist> artists, String venueName){
        Map<String, Integer> capacities = venueCapacityValues.getVenueCapacityValues();

        String outputFile = venueName + " " + currentMonth + ".csv";

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFile))){
            csvWriter.writeNext(new String[]{"Name", "Venue", "Stage", "Capacity", "Date", "Time", "Solo or Group", "Lead Performer Gender", "Lead Performer Age", "Genre"});

            for (Artist artist : artists) {
                String dateAssembly = artist.getDay() + " " + artist.getDate() + " " + currentMonth;
                // String status = artist.getStatus().equals("Buy Tickets") ? "Active" : "Cancelled";

                csvWriter.writeNext(new String[]{
                    artist.getName(),
                    venueName,
                    artist.getVenue(),
                    String.valueOf(capacities.get(artist.getVenue())),
                    dateAssembly,
                    artist.getTime(),
                    artist.getSoloOrGroup(),
                    artist.getLeadPerformerGender(),
                    String.valueOf(artist.getLeadPerformerAge()),
                    artist.getGenre()
                });
            }
            System.out.println("Created csv ");
        } catch (IOException e){
            e.printStackTrace();
        }
    }   

    public void joinCSVs()
    {
        VenueURLs venueURLs = new VenueURLs();
        List<String> venueList = venueURLs.getVenueList();

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(joinedCSVFileName))){
            csvWriter.writeNext(new String[]{"Name", "Venue", "Stage", "Capacity", "Date", "Time", "Solo or Group", "Lead Performer Gender", "Lead Performer Age", "Genre"});

            for (String venueName : venueList){
                String fileName = venueName + " " + currentMonth + ".csv";

                try (CSVReader reader = new CSVReader(new FileReader(fileName))){
                    String[] nextLine;

                    reader.readNext();

                    while ((nextLine = reader.readNext()) != null) {
                        csvWriter.writeNext(nextLine);
                    }   
                } catch (IOException | CsvValidationException el){
                    el.printStackTrace();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Joined CSVs");
    }
}
