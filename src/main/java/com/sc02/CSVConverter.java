package com.sc02;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

public class CSVConverter {
    private final String currentMonth = "";
    private String joinedCSVFileName = "name.csv"; // Insert name
    private VenueCapacityValues venueCapacityValues = new VenueCapacityValues();

    LinkedList<EventDetails> aprilList = new LinkedList<>();
    LinkedList<EventDetails> mayList = new LinkedList<>();
    LinkedList<EventDetails> juneList = new LinkedList<>();

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

    // Following section run to extract data from April and May to insert in June where applicable

    public void CSVComparitor(){
        String aprilFileName = "April.csv"; // Name as appropriate
        String mayFileName = "May.csv";
        String juneFileName = "June.csv";

        populateEventDetailsList(aprilFileName);
        populateEventDetailsList(mayFileName);
        populateEventDetailsList(juneFileName);

        for (EventDetails event : juneList){
            for (EventDetails aprilEvent : mayList){
                if (event.getName().equals(aprilEvent.getName())){
                    event.setSoloOrGroup(aprilEvent.getSoloOrGroup());
                    event.setLeadPerformerGender(aprilEvent.getLeadPerformerGender());
                    event.setLeadPerformerAge(aprilEvent.getLeadPerformerAge());
                    event.setGenre(aprilEvent.getGenre());
                }
            }

            for (EventDetails mayEvent : mayList){
                if (event.getName().equals(mayEvent.getName())){
                    event.setSoloOrGroup(mayEvent.getSoloOrGroup());
                    event.setLeadPerformerGender(mayEvent.getLeadPerformerGender());
                    event.setLeadPerformerAge(mayEvent.getLeadPerformerAge());
                    event.setGenre(mayEvent.getGenre());
                }
            }
        } 
        recreateCSV();
    }

    private void populateEventDetailsList(String fileName)
    {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))){
            String[] nextLine;

            reader.readNext();
            
            while ((nextLine = reader.readNext()) != null){
                String name = nextLine[0];
                String venue = nextLine[1];
                String stage = nextLine[2];
                String venueCapacity = nextLine[3];
                String date = nextLine[4];
                String time = nextLine[5];
                String soloOrGroup = nextLine[6];
                String leadPerformerGender = nextLine[7];
                String leadPerformerAge = nextLine[8];
                String genre = nextLine[9];

                EventDetails eventDetails = new EventDetails(name, venue, stage, venueCapacity, date,
                                                time, soloOrGroup, leadPerformerGender, leadPerformerAge, genre);

                if (fileName.contains("April")){
                    aprilList.add(eventDetails);
                }
                if (fileName.contains("May")){
                    mayList.add(eventDetails);   
                }
                if (fileName.contains("June")){
                    juneList.add(eventDetails);
                }
            }
              
        } catch (IOException | CsvValidationException el){
            el.printStackTrace();
        }
    }

    private void recreateCSV(){
        String recreatedCSV = "June Recreated.csv";

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(recreatedCSV))){
            csvWriter.writeNext(new String[]{"Name", "Venue", "Stage", "Capacity", "Date", "Time", "Solo or Group", "Lead Performer Gender", "Lead Performer Age", "Genre"});

            for (EventDetails event : juneList) {

                csvWriter.writeNext(new String[]{
                    event.getName(),
                    event.getVenue(),
                    event.getStage(),
                    event.getVenueCapacity(),
                    event.getDate(),
                    event.getTime(),
                    event.getSoloOrGroup(),
                    event.getLeadPerformerGender(),
                    event.getLeadPerformerAge(),
                    event.getGenre()
                });
            }
            System.out.println("Created csv ");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
