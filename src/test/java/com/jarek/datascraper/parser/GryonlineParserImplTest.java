package com.jarek.datascraper.parser;

import com.jarek.datascraper.config.GryOnlineProperties;
import com.jarek.datascraper.config.PageParserProperties;
import com.jarek.datascraper.entity.Videogame;
import org.jsoup.nodes.Document;
import org.jsoup.select.Selector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GryonlineParserImplTest {

    @Spy
    PageParser pageParser;

    PageParserProperties properties;

    @Mock
    DocumentCreator documentCreator;

    @Mock
    GryonlineHelper helper;

    @InjectMocks
    @Spy
    GryonlineParserImpl parser;



    @Test
    public void shouldReturnListOfGames() {

        Videogame game = new Videogame("title", "releaseDate", "genre", "description", "platform");
        Videogame game2 = new Videogame("title2", "releaseDate", "genre", "description", "platform");
        List<Videogame> expectedList = Arrays.asList(game, game2);

        when(helper.countPages(anyString())).thenReturn(2);

        doReturn("URL1").when(helper).appendToURL("URL", 1);
        doReturn("URL2").when(helper).appendToURL("URL", 2);

        doReturn(Arrays.asList(game)).when(parser).getVideogamesFromPage("URL1");
        doReturn(Arrays.asList(game2)).when(parser).getVideogamesFromPage("URL2");

        List<Videogame> actualList = parser.getAllVideogames("URL","param");

        assertEquals(expectedList, actualList);
    }

    @Test
    public void shouldGetListsFromCorrectNumberOfPages() {

        int pages = 215;
        List<Videogame> game = Arrays.asList(new Videogame("title", "releaseDate", "genre", "description", "platform"));
        when(helper.countPages(anyString())).thenReturn(pages);

        for (;  pages>0; pages--){
            doReturn("URL"+pages).when(helper).appendToURL("URL", pages);
        }
        doReturn(game).when(parser).getVideogamesFromPage(anyString());
        parser.getAllVideogames("URL", "param");
        verify(parser, never()).getVideogamesFromPage("URL0");
        verify(parser, never()).getVideogamesFromPage("URL216");
    }

}