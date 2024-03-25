package com.sc02;

public class Artist {
    public String name;
    public String venue;
    public String day;
    public String date;
    public String time;
    public String status;

    public Artist(String name, String venue, String day, String date, String time, String status)
    {
        this.name = name;
        this.venue = venue;
        this.day = day;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    @Override
        public String toString() {
            return "Artist: " + name +
                    "\nLocation: " + venue +
                    "\nDay: " + day +
                    "\nDate: " + date +
                    "\nTime: " + time +
                    "\nStatus: " + status +
                    "\n";
        }
}
