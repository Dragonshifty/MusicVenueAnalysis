package com.sc02;
import java.util.Map;
import java.util.HashMap;

public class VenueCapacityValues {
    private static Map<String, Integer> venueCapacities = new HashMap<>();

    static{
        venueCapacities.put("O2 Academy Birmingham", 3859);
        venueCapacities.put("O2 Academy Bournemouth", 2550);
        venueCapacities.put("O2 Academy Bristol", 1600);
        venueCapacities.put("O2 Academy Brixton", 2315);
        venueCapacities.put("O2 Academy Edinburgh", 3000);
        venueCapacities.put("O2 Academy Glasgow", 2500);
        venueCapacities.put("O2 Academy Islington", 800);
        venueCapacities.put("O2 Academy Leeds", 2300);
        venueCapacities.put("O2 Academy Leicester", 1450);
        venueCapacities.put("O2 Academy Liverpool", 1200);
        venueCapacities.put("O2 Academy Oxford", 1020);
        venueCapacities.put("O2 Academy Sheffield", 2350);
        venueCapacities.put("O2 Apollo Manchester", 3500);
        venueCapacities.put("O2 City Hall Newcastle", 2000);
        venueCapacities.put("O2 Forum Kentish Town", 2300);
        venueCapacities.put("O2 Guildhall Southampton", 1749);
        venueCapacities.put("O2 Institute Birmingham", 1500);
        venueCapacities.put("O2 Ritz Manchester", 1500);
        venueCapacities.put("O2 Shepherd's Bush Empire", 2000);
        venueCapacities.put("O2 Victoria Warehouse Manchester", 3500);
        venueCapacities.put("The O2", 20000);
    }

    public Map<String, Integer> getVenueCapacityValues(){
        return venueCapacities;
    }
}
