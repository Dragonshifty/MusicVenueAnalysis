package com.sc02;

public class EventDetails {
    private String name;
    private String venue;
    private String stage;
    private String venueCapacity;
    private String date;
    private String time;
    private String soloOrGroup;
    private String leadPerformerGender;
    private String leadPerformerAge;
    private String genre;

    public EventDetails(String name, String venue, String stage, String venueCapacity, String date, 
                        String time, String soloOrGroup, String leadPerformerGender, 
                        String leadPerformerAge, String genre)
    {
        this.name = name;
        this.venue = venue;
        this.stage = stage;
        this.venueCapacity = venueCapacity;
        this.date = date;
        this.time = time;
        this.soloOrGroup = soloOrGroup;
        this.leadPerformerGender = leadPerformerGender;
        this.leadPerformerAge = leadPerformerAge;
        this.genre = genre;
    }

    public String getName(){
        return name;
    }

    public String getVenue(){
        return venue;
    }

    public String getStage(){
        return stage;
    }

    public String getVenueCapacity(){
        return venueCapacity;
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

    public String getLeadPerformerAge(){
        return leadPerformerAge;
    }

    public String getGenre(){
        return genre;
    }

    public void setSoloOrGroup(String value){
        soloOrGroup = value;
    }

    public void setLeadPerformerGender(String value){
        leadPerformerGender = value;
    }

    public void setLeadPerformerAge(String value){
        leadPerformerAge = value;
    }

    public void setGenre(String value){
        genre = value;
    }
}
