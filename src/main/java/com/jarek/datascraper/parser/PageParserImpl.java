package com.jarek.datascraper.parser;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class PageParserImpl implements PageParser {

    private DocumentCreator documentCreator;

    @Autowired
    public PageParserImpl(DocumentCreator documentCreator) {
        this.documentCreator = documentCreator;
    }

    @Override
    public List<String> getParsedStrings(Document document, String parserParam) {

        List<String> parsedStringsList = new ArrayList<>();

        Elements elements = document.select(parserParam);

        elements.forEach(element -> parsedStringsList.add(element.text()));

        return  parsedStringsList;
    }

    @Override
    public List<String> getParsedStringsOwnTextMethod(Document document, String parserParam) {

        List<String> parsedStringsList = new ArrayList<>();

        Elements elements = document.select(parserParam);

        elements.forEach(element -> parsedStringsList.add(element.ownText()));

        return  parsedStringsList;
    }

    @Override
    public String getSingleParsedString(String URL, String parserParam) {

        return documentCreator.createDocument(URL)
                              .select(parserParam)
                              .first()
                              .text();
    }

//    public Elements getElementsFromPage(String url, String... parserParam) {
//
//        Document document = documentCreator.createDocument(url);
//
//
//    }
}
