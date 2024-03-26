package com.sc02;
import org.jsoup.*; 
import org.jsoup.nodes.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLConverter {
    private final String fileName = "scraped_html.html";

    public void convertToHTML (Document doc)
    {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(doc.outerHtml());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Document loadDocFromHTML (){
        Document loadedDoc = new Document(null);
        try {
            loadedDoc = Jsoup.parse(new File(fileName), "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedDoc;
    }
}
