package com.sc02;

public class Artist {
    private String name;
    private String venue;
    private int venueCapacity;
    private String day;
    private String date;
    private String time;
    private String soloOrGroup = "Group";
    private String leadPerformerGender = "Unknown";
    private int leadPerformerAge;
    private String genre = " ";

    public Artist(String name, String venue, String day, String date, String time)
    {
        this.name = name;
        this.venue = venue;
        this.day = day;
        this.date = date;
        this.time = time;
    }

    public void setVenueCapacity(int venueCapacity){
        this.venueCapacity = venueCapacity;
    }

    public void setLeadPerformerGender(String leadPerformerGender)
    {
        this.leadPerformerGender = leadPerformerGender;
    }

    public void setLeadPerformerAge(int leadPerformerAge){
        this.leadPerformerAge = leadPerformerAge;
    }

    public String getName(){
        return name;
    }

    public String getVenue(){
        return venue;
    }

    public int getVenueCapacity(){
        return venueCapacity;
    }

    public String getDay(){
        return day;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }

    public String getSoloOrGroup(){
        return soloOrGroup;
    }

    public String getLeadPerformerGender(){
        return leadPerformerGender;
    }

    public int getLeadPerformerAge(){
        return leadPerformerAge;
    }

    public String getGenre(){
        return genre;
    }

    @Override
        public String toString() {
            return "Artist: " + name +
                    "\nLocation: " + venue +
                    "\nDay: " + day +
                    "\nDate: " + date +
                    "\nTime: " + time +
                    "\nSolo or Group: " + soloOrGroup +
                    "\nGender: " + leadPerformerGender +
                    "\nAge: " + leadPerformerAge +
                    "\nGenre: " + genre +
                    "\n";
        }
}
