package com.jarek.datascraper.parser;

import com.jarek.datascraper.config.GryOnlineProperties;
import org.jsoup.nodes.Document;
import org.jsoup.select.Selector;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GryonlineParserImplTest {

    @Mock
    Document documentt;

    @Mock
    GryOnlineProperties properties;

    @Autowired
    DocumentCreator documentCreator;

    @InjectMocks
    PageParser pageParser;



    @Test
    public void shoudThrowExceptionWhenWrongParameterArgument() {

//        Document document = new Document(properties.getAfterReleaseURL());
        Document document = documentCreator.createDocument("https://www.gry-online.pl/gry/13vh");


        System.out.println(document.baseUri());
//        System.out.println(properties.getAfterReleaseURL());

//        when(documentCreator.createDocument("https://www.gry-online.pl/gry/13vh")).thenReturn(document);
        assertThrows(Selector.SelectorParseException.class, () -> pageParser.getSingleParsedString(any(),"wrong"));



    }




}