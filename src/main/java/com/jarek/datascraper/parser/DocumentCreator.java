package com.jarek.datascraper.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentCreator {

    public Document createDocument(String URL) {

        try {
            return Jsoup.connect(URL)
                        .get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
