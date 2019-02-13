package com.jarek.datascraper.parser;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
class GryonlineHelperTest {

    @Mock
    PageParser pageParser;

    @InjectMocks
    GryonlineHelper gryonlineHelper;

    @Test
    public void shouldReturnPageRanges() {

        int i = 868;

//        doReturn(i).when(gryonlineHelper).countPages("a[href=/gry/22]>stxt");
//        when(gryonlineHelper.countPages("a[href=/gry/22]>stxt")).thenReturn(i);
        assertEquals(gryonlineHelper.countPageRanges(868, 10 )[2],174 );


    }

    @Test
    public void shouldReturnPageCount() {

        when(pageParser.getSingleParsedString(any(),any())).thenReturn("20832");
        assertEquals(gryonlineHelper.countPages("a[href=/gry/22]>stxt"), 868);


    }

}