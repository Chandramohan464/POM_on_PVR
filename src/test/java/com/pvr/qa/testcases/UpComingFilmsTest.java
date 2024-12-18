package com.pvr.qa.testcases;

import com.pvr.qa.base.BaseClass;
import com.pvr.qa.pages.UpComingFilms;
import io.qameta.allure.*;
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
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the upcoming movies are displayed correctly")
    @Feature("Upcoming Movies Display")
    @Story("User checks if the upcoming movies section is displayed correctly")
    public void CheckUpComingDisplayTest(){
        logger.info("upcoming movie test started");
        upComingFilms.checkUpComingDisplay();
        logger.info("upcoming movie test ended");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the count of upcoming movies displayed")
    @Feature("Upcoming Movies Count")
    @Story("User verifies the count of upcoming movies")
    public void countUpComingMoviesTest(){
        logger.info("count upcoming movie test started");
        int count = upComingFilms.countUpComingMovies();
        System.out.println("Upcoming movie's count: " + count);
        logger.info("count upcoming movie test ended");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the dates of upcoming movies are displayed correctly")
    @Feature("Upcoming Movies Dates")
    @Story("User checks if the dates of upcoming movies are displayed correctly")
    public void upComingMovieDatesTest(){
        logger.info("upcoming movie dates test started");
        upComingFilms.upComingMovieDates();
        logger.info("upcoming movie dates test ended");
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the functionality of the 'See All' button in the upcoming movies section")
    @Feature("See All Button Functionality")
    @Story("User checks the functionality of the 'See All' button for upcoming movies")
    public void checkSeeAllButtonTest(){
        logger.info("upcoming movie dates test started");
        upComingFilms.checkSeeAllButton();
        logger.info("upcoming movie dates test ended");
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that a movie can be added to the wishlist")
    @Feature("Add to Wishlist Functionality")
    @Story("User adds an upcoming movie to the wishlist")
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
