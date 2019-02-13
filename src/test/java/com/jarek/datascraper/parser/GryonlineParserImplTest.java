package com.jarek.datascraper.parser;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GryonlineParserImplTest {

    @Mock
    PageParser pageParser;

    @InjectMocks
    GryonlineParserImpl gryonlineParser;

//    @Test
//    public void shouldReturnRoundedNumberOfPagesToParse() {
//
//        when(pageParser.getSingleParsedString("https://www.gry-online.pl/gry/", "stxt")).thenReturn("20832");
//
//        assertEquals( 868,gryonlineParser.countPages());
//
//        verify(pageParser).getSingleParsedString("https://www.gry-online.pl/gry/", "stxt");
//    }
//
//    @Test
//    public void shouldAppendPageNumberToURL() {
//
//        assertAll("Should append page number to URL",
//                ()-> assertEquals(gryonlineParser.appendToURL("https://www.gry-online.pl/gry/02vh-", 23), "https://www.gry-online.pl/gry/02vh-23"),
//                ()->assertEquals(gryonlineParser.appendToURL("https://www.gry-online.pl/gry/02vh-", 500), "https://www.gry-online.pl/gry/02vh-500"),
//                ()->assertEquals(gryonlineParser.appendToURL("https://www.gry-online.pl/gry/02vh-", 1500), "https://www.gry-online.pl/gry/02vh-1500")
//                );
//
//    }

}