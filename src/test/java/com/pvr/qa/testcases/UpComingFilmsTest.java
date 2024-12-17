package com.pvr.qa.testcases;

import com.pvr.qa.base.BaseClass;
import com.pvr.qa.pages.UpComingFilms;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpComingFilmsTest extends BaseClass {

    UpComingFilms upComingFilms;
    private static final Logger logger = LogManager.getLogger(UpComingFilmsTest.class);

    public UpComingFilmsTest(){

        super();
    }

    @BeforeMethod
    public void setUp(){

        initialize();
        upComingFilms = new UpComingFilms();
    }

    @Test(priority = 1)
    public void CheckUpComingDisplayTest(){

        logger.info("upcoming movie test started");
        upComingFilms.checkUpComingDisplay();
        logger.info("upcoming movie test ended");
    }

    @Test(priority = 2)
    public void countUpComingMoviesTest(){

        logger.info("count upcoming movie test started");
        int count=upComingFilms.countUpComingMovies();
        System.out.println("Upcoming movie's count: "+count);
        logger.info("count upcoming movie test ended");
    }

    @Test(priority = 3)
    public void upComingMovieDatesTest(){

        logger.info("upcoming movie test started");
        upComingFilms.upComingMovieDates();
        logger.info("upcoming movie test ended");
    }

    @Test(priority = 4)
    public void checkSeeAllButtonTest(){

        logger.info("upcoming movie dates test started");
        upComingFilms.checkSeeAllButton();
        logger.info("upcoming movie dates test ended");
    }

    @Test(priority = 5)
    public void checkAddToWishesTest(){

        logger.info("add to wish test started");
        upComingFilms.checkAddToWishes();
        logger.info("add to wish test ended");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
