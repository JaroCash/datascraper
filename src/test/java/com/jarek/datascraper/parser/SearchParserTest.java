package com.jarek.datascraper.parser;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

public class SearchParserTest {

    GryonlineParserImpl searchParser;

    @BeforeEach
    public void setUp() {
//       searchParser = new SearchParserImpl();
    }

    @Test
    public void shouldReturnFirstSearchValue() {

        Map<String, String> requestParamsMap = new HashMap<>();
        requestParamsMap.put("search", "gta");
        requestParamsMap.put("dzial"," ");

        String page = HTTPGetConnector.executePost("https://www.gry-online.pl/szukaj.asp", requestParamsMap);

//        assertEquals("<h5>Grand Theft Auto V</h5>", searchParser.parsePage(page) );
    }


}