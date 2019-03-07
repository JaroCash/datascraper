package com.jarek.datascraper.parser;

import com.jarek.datascraper.config.GryOnlineProperties;
import com.jarek.datascraper.config.PageParserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class GryonlineHelper {

    private GryOnlineProperties properties;

    private PageParser pageParser;

    @Autowired
    public GryonlineHelper(GryOnlineProperties properties, PageParser pageParser) {
        this.properties = properties;
        this.pageParser = pageParser;
    }


    public int countPages(String parserParam) {

        String resultString = pageParser.getSingleParsedString(properties.getPageCountURL(), parserParam );

        int numberOfPages = (int) Math.ceil((Double.parseDouble(resultString))/24);

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

        System.out.println(Arrays.toString(calculatedRanges));

        return calculatedRanges;

    }
}
