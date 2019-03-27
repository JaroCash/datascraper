package com.jarek.datascraper.parser;

import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PageParserImplTest {

    @Mock
    DocumentCreator documentCreator;

    @InjectMocks
    PageParserImpl pageParser;

    @Test
    public void shouldReturnParsedDescription() {

        Document document = documentCreator.createDocument("https://www.gry-online.pl/gry/02vh-1");

        when(documentCreator.createDocument("https://www.gry-online.pl/gry/02vh-1")).thenReturn(document);

    }

}