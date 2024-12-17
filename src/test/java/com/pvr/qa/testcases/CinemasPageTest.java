package com.pvr.qa.testcases;

import com.pvr.qa.base.BaseClass;
import com.pvr.qa.pages.CinemasPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CinemasPageTest extends BaseClass {

    CinemasPage cinemasPage;
    private static final Logger logger = LogManager.getLogger(CinemasPageTest.class);

    public CinemasPageTest(){

        super();
    }

    @BeforeMethod
    public void setUp(){

        initialize();
        cinemasPage = new CinemasPage();
    }

    @Test(priority = 1)
    public void numberOfTheatersTest(){

        logger.info("number of theater's test started");
        cinemasPage.numberOfTheaters();
        logger.info("number of theater's test ended");
    }

    @Test(priority = 2)
    public void checkForDisplayOfExperiencesTest(){

        logger.info("Check for display of experiences test started");
        boolean validatePage=cinemasPage.checkForDisplayOfExperiences();
        logger.info("Verifying if experiences are displayed: " + validatePage);
        Assert.assertTrue(validatePage);
        logger.info("Check for display of experiences test ended");
    }

    @Test(priority = 3)
    public void checksearchBarIsDisplayedTest(){

        logger.info("Check search bar is displayed test started");
        logger.info("Verifying if the search bar is displayed: ");
        cinemasPage.checksearchBarIsDisplayed();
        logger.info("Check search bar is displayed test ended");
    }

    @Test(priority = 4)
    public void countPVRCinemaTest(){

        logger.info("Check search bar is displayed test started");
        logger.info("Verifying if the search bar is displayed: ");
        cinemasPage.countPVRCinema();
        logger.info("Check search bar is displayed test ended");
    }

    @Test(priority = 5)
    public void totalCinemasUnderSevenTest(){

        logger.info("Check search bar is displayed test started");
        logger.info("Verifying total cinemas: ");
        cinemasPage.totalCinemasUnderSeven();
        logger.info("Check search bar is displayed test ended");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
