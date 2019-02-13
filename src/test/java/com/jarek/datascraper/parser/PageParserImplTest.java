package com.jarek.datascraper.parser;

import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
public class PageParserImplTest {

    @Mock
    DocumentCreator documentCreator;

    @InjectMocks
    PageParserImpl pageParser;

    @Test
    public void shouldReturnParsedDescription() {

        Document document = documentCreator.createDocument("https://www.gry-online.pl/gry/02vh-1");

        when(documentCreator.createDocument("https://www.gry-online.pl/gry/02vh-1")).thenReturn(document);

//       List<String> descriptionList = pageParser.getParsedStrings("https://www.gry-online.pl/gry/02vh-1", ".lista lista-gry>.box>p:nth-child(4)");

//        System.out.println(descriptionList.get(0));

//       assertEquals(descriptionList.get(0), "Utrzymana w baśniowej stylistyce platformówka z elementami gry przygodowej i logicznej. W Macrotis: A Mother’s Journey wcielamy się w Bilby – matkę trójki małych gryzoni, z którymi została rozdzielona podczas potężnej powodzi. Jej zadaniem jest dotarcie do swoich pociech, nim spotka je krzywda.");



    }

}