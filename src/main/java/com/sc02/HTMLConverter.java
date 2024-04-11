package com.sc02;
import org.jsoup.*; 
import org.jsoup.nodes.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLConverter {
    private final String currentMonth = "";

    public void convertToHTML (Document doc, String venueName)
    {
        String fileName = venueName + " " + currentMonth + ".html"; 
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(doc.outerHtml());
            System.out.println(fileName + " created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Document loadDocFromHTML (String venueName){
        Document loadedDoc = new Document(null);
        String fileName = venueName + " " + currentMonth + ".html";
        try {
            loadedDoc = Jsoup.parse(new File(fileName), "UTF-8");
            System.out.println(fileName + " loaded");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedDoc;
    }
}
