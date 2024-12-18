package com.pvr.qa.testcases;

import com.pvr.qa.base.BaseClass;
import com.pvr.qa.pages.CinemasPage;
import io.qameta.allure.*;
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
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the number of theaters displayed")
    @Feature("Theater Information")
    @Story("User checks the total number of theaters available")
    public void numberOfTheatersTest(){

        logger.info("number of theater's test started");
        cinemasPage.numberOfTheaters();
        logger.info("number of theater's test ended");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify the display of cinema experiences")
    @Feature("Experience Display")
    @Story("User validates if cinema experiences are displayed correctly on the page")
    public void checkForDisplayOfExperiencesTest() {

        logger.info("Check for display of experiences test started");
        boolean validatePage = cinemasPage.checkForDisplayOfExperiences();
        logger.info("Verifying if experiences are displayed: " + validatePage);
        Assert.assertFalse(validatePage);
        logger.info("Check for display of experiences test ended");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the search bar is displayed on the cinemas page")
    @Feature("Search Bar Functionality")
    @Story("User checks for the presence of the search bar on the page")
    public void checksearchBarIsDisplayedTest() {

        logger.info("Check search bar is displayed test started");
        logger.info("Verifying if the search bar is displayed: ");
        cinemasPage.checksearchBarIsDisplayed();
        logger.info("Check search bar is displayed test ended");
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the count of PVR Cinemas displayed on the cinemas page")
    @Feature("PVR Cinema Count")
    @Story("User validates the total number of PVR Cinemas available")
    public void countPVRCinemaTest() {

        logger.info("Count PVR Cinema test started");
        logger.info("Verifying the count of PVR Cinemas: ");
        cinemasPage.countPVRCinema();
        logger.info("Count PVR Cinema test ended");
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the total number of cinemas listed under seven categories")
    @Feature("Cinema Listing")
    @Story("User checks the total count of cinemas categorized under seven categories")
    public void totalCinemasUnderSevenTest() {

        logger.info("Total cinemas under seven test started");
        logger.info("Verifying total cinemas: ");
        cinemasPage.totalCinemasUnderSeven();
        logger.info("Total cinemas under seven test ended");
    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
