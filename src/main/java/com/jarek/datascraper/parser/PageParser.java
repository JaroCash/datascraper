package com.jarek.datascraper.parser;

import org.jsoup.nodes.Document;

import java.util.List;

public interface PageParser {

    List<String> getParsedStrings(Document document, String parserParam);

    List<String> getParsedStringsOwnTextMethod(Document document, String parserParam);

    String getSingleParsedString(String URL, String parserParam);

}
