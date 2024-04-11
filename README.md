Music Venue Analysis Data Scraping and Manipulation

This program is design to be run in sections. Ideally I would have given it a UI such as JavaFX or Unity but, given the dataset complexity, this seemed inefficient for the task.

- Venue URLs must be placed into the VenueURLs.java file, along with the venue names.
- Each given month must also be placed into the CSVConverter.java, JsonConverter.java (if applicable), and HTMLConverter.java files.
- Although the program can scrape and output direct to CSV, I have first scraped to HTML in five second increments (so as not to stress the server), and extracted elements from there.
- The program then combines all the CSVs into one joined CSV, where appplicable for each month.
- Lastly, I added a functionality in the CSVConverter file that extracts the two previous months values from their respective CSVs, converts them to objects and then compares with the most recent month's CSV to fill in values automatically where they appear to save time.
