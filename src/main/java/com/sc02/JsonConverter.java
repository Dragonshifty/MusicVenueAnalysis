package com.sc02;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

public class JsonConverter {
    private final String currentMonth = "";
    private String venueName;
    private Map<String, Object> artistMap = new LinkedHashMap<>();
    private VenueCapacityValues venueCapacityValues = new VenueCapacityValues();

    public void processToMap(List<Artist> artists){
        Map<String, Integer> capacities = venueCapacityValues.getVenueCapacityValues();

        for (Artist artist : artists){
            Map<String, Object> JsonHeader = new LinkedHashMap<>();
            String dateAssembly = artist.getDay() + " " + artist.getDate() + " " + currentMonth;
            venueName = artist.getVenue() + " " + currentMonth;

            JsonHeader.put("Venue", artist.getVenue());
            JsonHeader.put("Capacity", capacities.get(artist.getVenue()));
            JsonHeader.put("Date", dateAssembly);
            JsonHeader.put("Time", artist.getTime());
            JsonHeader.put("Solo or Group", artist.getSoloOrGroup());
            JsonHeader.put("Lead Performer Gender", artist.getLeadPerformerGender());
            JsonHeader.put("Lead Performer Age", artist.getLeadPerformerAge());
            JsonHeader.put("Genre", artist.getGenre());

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
