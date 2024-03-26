package com.sc02;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;

public class JsonConverter {
    private final String currentMonth = "April";
    private String venueName;
    private Map<String, Object> artistMap = new HashMap<>();
    private VenueCapacityValues venueCapacityValues = new VenueCapacityValues();

    public void processToMap(List<Artist> artists){
        Map<String, Integer> capacities = venueCapacityValues.getVenueCapacityValues();

        for (Artist artist : artists){
            Map<String, Object> JsonHeader = new HashMap<>();
            String dateAssembly = artist.getDay() + " " + artist.getDate() + " " + currentMonth;
            venueName = artist.getVenue() + " " + currentMonth;
            
            JsonHeader.put("Lead Performer", artist.getName());

            Map<String, Object> details = new HashMap<>();

            details.put("Venue", artist.getVenue());
            details.put("Capacity", capacities.get(artist.getVenue()));
            details.put("Date", dateAssembly);
            details.put("Time", artist.getTime());
            details.put("Lead Performer Gender", artist.getLeadPerformerGender());
            details.put("Lead Performer Age", artist.getLeadPerformerAge());
            details.put("Ticket Status", artist.getStatus());

            JsonHeader.put("Details", details);

            artistMap.put(artist.getName(), JsonHeader);
        }
        convertToJson(); 
    }

    private void convertToJson(){
        Gson gson = new Gson();

        String artistJson = gson.toJson(artistMap);

        try (FileWriter writer = new FileWriter(venueName)) {
            writer.write(artistJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully outputted to Json");
    }
}
