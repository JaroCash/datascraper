package com.jarek.datascraper.parser;

import org.springframework.stereotype.Component;

@Component
public class GryonlineHelper {

    private final String URL_TO_GET_PAGES = "https://www.gry-online.pl/gry/";

    private PageParser pageParser;

    public GryonlineHelper(PageParser pageParser) {
        this.pageParser = pageParser;
    }

    public int countPages(String parserParam) {

        String resultString = pageParser.getSingleParsedString(URL_TO_GET_PAGES, parserParam );

       int numberOfPages = (int) Math.ceil((Double.parseDouble(resultString))/24);

//        int numberOfPages = 868;

        return numberOfPages;
    }


    public String appendToURL(String URL, int numberToAppend) {

        StringBuffer stringBuffer = new StringBuffer(URL);

        stringBuffer.append(String.valueOf(numberToAppend));

        return stringBuffer.toString();
    }

    public int[] countPageRanges(int numberOfPages, int numberOfRanges) {

        int [] calculatedRanges = new int [numberOfRanges+1];

        double range = Math.round((double)numberOfPages/numberOfRanges);
        System.out.println(range);

        for (int i = 0; i < numberOfRanges; i++) {
            calculatedRanges[i] = (int) range*i;
        }
        calculatedRanges[numberOfRanges] = numberOfPages;

        for (int i : calculatedRanges) {
            System.out.println(i);
        }

        return calculatedRanges;

    }
}
