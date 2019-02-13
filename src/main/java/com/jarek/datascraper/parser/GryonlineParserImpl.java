package com.jarek.datascraper.parser;

import com.jarek.datascraper.entity.Videogame;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class GryonlineParserImpl implements GryonlineParser {

    private PageParser pageParser;

    private DocumentCreator documentCreator;

    private GryonlineHelper gryonlineHelper;

    @Autowired
    public GryonlineParserImpl(PageParser pageParser, DocumentCreator documentCreator, GryonlineHelper gryonlineHelper) {
        this.pageParser = pageParser;
        this.documentCreator = documentCreator;
        this.gryonlineHelper = gryonlineHelper;
    }

    public List<Videogame> getAllVideogames(String url, String parserParam) {

        List<Videogame> allVideogamesList = new ArrayList<>();

        int numberOfPages = gryonlineHelper.countPages(parserParam);
        String URL;

        for (int i = 1; i <= numberOfPages; i++) {
         URL = gryonlineHelper.appendToURL(url, i);
         allVideogamesList.addAll(getVideogamesFromPage(URL));
        }
        return allVideogamesList;
    }

    @Override
    public List<Videogame> getVideogamesInPagesRange(String url, int start, int end) {

        List<Videogame> allVideogamesList = new ArrayList<>();
        String URL;

        for (int i = start; i <= end; i++) {
            URL = gryonlineHelper.appendToURL(url, i);
            allVideogamesList.addAll(getVideogamesFromPage(URL));
        }
        return allVideogamesList;
    }

    @Override
    public List<Videogame> getVideogamesFromPage(String url) {

        Document document = documentCreator.createDocument(url);

        List<Videogame> videogameList = new ArrayList<>();

        List<String> titlesList = pageParser.getParsedStrings(document, "h5");
        List<String> genreList = pageParser.getParsedStrings(document, ".opis-b>b");
        List<String> releaseDateList = pageParser.getParsedStringsOwnTextMethod(document, ".opis-b");
        List<String> descriptionList = pageParser.getParsedStrings(document, ".lista.lista-gry>.box>p:nth-child(4)");
        List<String> platformsList = pageParser.getParsedStrings(document, ".lista.lista-gry>.box>p:nth-child(5)");

        for (int i = 0; i < titlesList.size(); i++) {

            videogameList.add(new Videogame(titlesList.get(i), releaseDateList.get(i), genreList.get(i), descriptionList.get(i), platformsList.get(i)));

        }
        return videogameList;

    }

}
//.listalista-gry>.box>p:nth-child(4)