package com.jarek.datascraper.parser;


import com.jarek.datascraper.config.GryOnlineProperties;
import com.jarek.datascraper.config.PageParserProperties;
import org.jsoup.select.Selector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GryonlineHelperTest {

    @Mock
    PageParserImpl pageParser;

    @InjectMocks
    GryonlineHelper gryonlineHelper;

    @Test
    public void shouldAppendPageNumberToURL() {

        assertAll("Should append page number to URL",
                () -> assertEquals("https://www.gry-online.pl/gry/02vh-23", gryonlineHelper.appendToURL("https://www.gry-online.pl/gry/02vh-", 23)),
                () -> assertEquals("https://www.gry-online.pl/gry/02vh-500", gryonlineHelper.appendToURL("https://www.gry-online.pl/gry/02vh-", 500)),
                () -> assertEquals("https://www.gry-online.pl/gry/02vh-1500", gryonlineHelper.appendToURL("https://www.gry-online.pl/gry/02vh-", 1500))
        );
    }

    @Test
    public void shouldReturnCorrectNumberOfRanges() {

        assertAll(
                () -> assertThrows(ArrayIndexOutOfBoundsException.class, () -> Array.get(gryonlineHelper.countPageRanges(200, 20), 21)),
                () -> assertThrows(ArrayIndexOutOfBoundsException.class, () -> Array.get(gryonlineHelper.countPageRanges(450, 10), 11)),
                () -> assertThrows(ArrayIndexOutOfBoundsException.class, () -> Array.get(gryonlineHelper.countPageRanges(11, 10), 11))
        );
    }

    @Test
    public void shouldReturnPageRangesWhenPagesCountGreaterThanPageRanges() {

        assertAll(
                () -> assertEquals(174, gryonlineHelper.countPageRanges(868, 10)[2]),
                () -> assertEquals(36, gryonlineHelper.countPageRanges(215, 6)[1]),
                () -> assertEquals(137, gryonlineHelper.countPageRanges(137, 4)[4])
        );
    }

    @Test
    public void shouldReturnOneRangeWhenSmallNumberOfPages() {

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Array.get(gryonlineHelper.countPageRanges(5, 10), 2));
    }

    @Test
    public void shouldReturnOneRangeWithPagesWhenSmallNumberOfPages() {

        int[] resultArray = gryonlineHelper.countPageRanges(6, 10);

        assertAll(
                () -> assertEquals(0, resultArray[0]),
                () -> assertEquals(6, resultArray[1])
        );

    }

    @Test
    public void shouldReturnOneRangeWhenNumberOfPagesLesserThanPageRanges() {

        assertEquals(9, gryonlineHelper.countPageRanges(9, 10)[1]);
    }

    @Test
    public void shouldReturnPageCountBasedOnNumberOfGames() {

        doReturn("20832").when(pageParser).getSingleParsedString(any(), any());
        assertEquals(868, gryonlineHelper.countPages("a[href=/gry/22]>stxt"));

    }

    @Test
    public void shouldThrowExceptionWhenParserThrowsException() {

        when(pageParser.getSingleParsedString(any(), any())).thenThrow(Selector.SelectorParseException.class);

        assertThrows(Selector.SelectorParseException.class, () -> gryonlineHelper.countPages("a[href=/gry/22]>stxt"));

    }
}