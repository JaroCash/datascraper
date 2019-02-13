package com.jarek.datascraper.concurrent;

import com.jarek.datascraper.service.DataScrapeService;
import org.springframework.stereotype.Component;

@Component
public class DataScraperThreadRunner {

   /* private final GryonlineScrapeService gryonlineScrapeService;*/

    private final DataScrapeService dataScrapeService;

    public DataScraperThreadRunner(DataScrapeService dataScrapeService) {
        this.dataScrapeService = dataScrapeService;
    }

  /*  @Autowired
    public DataScraperThreadRunner(GryonlineScrapeService gryonlineScrapeService) {
        this.gryonlineScrapeService = gryonlineScrapeService;
    }*/

    public void  startThread() throws Exception {

//        gryonlineScrapeService.print(200);
//        gryonlineScrapeService.print(400);
//        gryonlineScrapeService.print(600);
//        gryonlineScrapeService.print(800);

//        dataScrapeService.scrapeVideogamesInPageRange(0,100);
//        dataScrapeService.scrapeVideogamesInPageRange(101,200);
//        dataScrapeService.scrapeVideogamesInPageRange(201,300);
//        dataScrapeService.scrapeVideogamesInPageRange(301,400);

    }
}
