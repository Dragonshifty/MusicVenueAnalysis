package com.sc02;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class VenueURLs {
    private static Map<String, String> venues = new HashMap<>();
    private static List<String> venueList = new ArrayList<>();

    static { 
        // Insert Venue Page Links into venues HashMap - venue name, venue Link
        venues.put("","");
        
        // Insert venue names into venue List
        venueList.add("");
    }

    public Map<String, String> getVenueURLs(){
        return venues;
    }

    public List<String> getVenueList(){
        return venueList;
    }
}
