package com.sc02;
import java.util.Map;
import java.util.HashMap;

public class VenueCapacityValues {
    private static Map<String, Integer> venueCapacities = new HashMap<>();

    static{
        // Insert venue name, venue capacity value into HashMap
        venueCapacities.put("", 0);
    }

    public Map<String, Integer> getVenueCapacityValues(){
        return venueCapacities;
    }
}
