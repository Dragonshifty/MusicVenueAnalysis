package com.sc02;
import java.util.Map;
import java.util.HashMap;

public class VenueURLs {
    private static Map<String, String> venues = new HashMap<>();

    static {
        venues.put("O2 Academy Birmingham", "https://www.academymusicgroup.com/o2academybirmingham/events/month/2024-04");
        venues.put("O2 Academy Bournemouth", "https://www.academymusicgroup.com/o2academybournemouth/events/month/2024-04");
        venues.put("O2 Academy Bristol", "https://www.academymusicgroup.com/o2academybristol/events/month/2024-04");
        venues.put("O2 Academy Brixton", "https://www.academymusicgroup.com/o2academybrixton/events/month/2024-05");
        venues.put("O2 Academy Edinburgh", "https://www.academymusicgroup.com/o2academyedinburgh/events/month/2024-04");
        venues.put("O2 Academy Glasgow", "https://www.academymusicgroup.com/o2academyglasgow/events/month/2024-04");
        venues.put("O2 Academy Islington", "https://www.academymusicgroup.com/o2academyislington/events/month/2024-04");
        venues.put("O2 Academy Leeds", "https://www.academymusicgroup.com/o2academyleeds/events/month/2024-04");
        venues.put("O2 Academy Leicester", "https://www.academymusicgroup.com/o2academyleicester/events/month/2024-04");
        venues.put("O2 Academy Liverpool", "https://www.academymusicgroup.com/o2academyliverpool/events/month/2024-04");
        venues.put("O2 Academy Oxford", "https://www.academymusicgroup.com/o2academyoxford/events/month/2024-04");
        venues.put("O2 Academy Sheffield", "https://www.academymusicgroup.com/o2academysheffield/events/month/2024-04");
        venues.put("O2 Apollo Manchester", "https://www.academymusicgroup.com/o2apollomanchester/events/month/2024-04");
        venues.put("O2 City Hall Newcastle", "https://www.academymusicgroup.com/o2cityhallnewcastle/events/month/2024-04");
        venues.put("O2 Forum Kentish Town", "https://www.academymusicgroup.com/o2forumkentishtown/events/month/2024-04");
        venues.put("O2 Guildhall Southampton", "https://www.academymusicgroup.com/o2guildhallsouthampton/events/month/2024-04");
        venues.put("O2 Institute Birmingham", "https://www.academymusicgroup.com/o2institutebirmingham/events/month/2024-04");
        venues.put("O2 Ritz Manchester", "https://www.academymusicgroup.com/o2ritzmanchester/events/month/2024-04");
        venues.put("O2 Shepherd's Bush Empire", "https://www.academymusicgroup.com/o2shepherdsbushempire/events/month/2024-04");
        venues.put("O2 Victoria Warehouse Manchester", "https://www.academymusicgroup.com/o2victoriawarehousemanchester/events/month/2024-04");
    }

    public Map<String, String> getVenueURLs(){
        return venues;
    }
}
