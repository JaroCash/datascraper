package com.jarek.datascraper.parser;

import com.jarek.datascraper.config.PageParserProperties;
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

    private PageParserProperties properties;

    @Autowired
    public GryonlineParserImpl(PageParser pageParser, DocumentCreator documentCreator, GryonlineHelper gryonlineHelper, PageParserProperties properties) {
        this.pageParser = pageParser;
        this.documentCreator = documentCreator;
        this.gryonlineHelper = gryonlineHelper;
        this.properties = properties;
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

        List<String> titlesList = pageParser.getParsedStrings(document, properties.getTitleParam());
        List<String> genreList = pageParser.getParsedStrings(document, properties.getGenreParam());
        List<String> releaseDateList = pageParser.getParsedStringsOwnTextMethod(document, properties.getReleaseDateParam());
        List<String> descriptionList = pageParser.getParsedStrings(document, properties.getDescriptionParam());
        List<String> platformsList = pageParser.getParsedStrings(document, properties.getPlatformParam());

        for (int i = 0; i < titlesList.size(); i++) {

            videogameList.add(new Videogame(titlesList.get(i), releaseDateList.get(i), genreList.get(i), descriptionList.get(i), platformsList.get(i)));

        }
        return videogameList;
    }

}
