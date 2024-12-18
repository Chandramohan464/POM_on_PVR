package com.pvr.qa.testcases;

import com.pvr.qa.base.BaseClass;
import com.pvr.qa.pages.HomePage;
import com.pvr.qa.util.TestUtil;
import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class HomePageTest extends BaseClass {

    String sheetName="LocationSheet";
    HomePage homePage;
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);


    public HomePageTest(){

        super();
    }

    @BeforeMethod
    public void setUp(){

        initialize();
        homePage = new HomePage();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the homepage images are displayed correctly")
    @Feature("Image Display")
    @Story("User checks if images are visible on the homepage")
    public void checkImageDisplayTest() {

        logger.info("Check image display test started");
        boolean validateImage = homePage.checkImageDisplay();
        Assert.assertTrue(validateImage);
        logger.info("Check image display test ended");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the user can select a location successfully")
    @Feature("Location Selection")
    @Story("User selects a location from the dropdown or input field")
    public void selectLocationTest() throws InterruptedException {

        logger.info("Select location test started");
        String location = prop.getProperty("location");
        homePage.selectLocation(location);
        logger.info("Select location test ended");
    }


    @DataProvider
    public Object[][] getPVRTestData() throws IOException {

        return TestUtil.getTestData(sheetName);
    }

    @Test(priority = 3, dataProvider = "getPVRTestData")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the user can select a location using data from an external source (xlsx sheet)")
    @Feature("Location Selection with DataProvider")
    @Story("User selects a location based on data provided from an xlsx file")
    public void selectLocationDataTest(String location) throws InterruptedException {

        logger.info("Select location test started using xlsx sheet");
        homePage.selectLocationData(location);
        logger.info("Select location test ended using xlsx sheet");
    }


    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the user can search for a movie using the movie name")
    @Feature("Movie Search Functionality")
    @Story("User searches for a movie and verifies if the movie search is successful")
    public void searchMovieTest() {
        logger.info("search movie test started");
        String movieName = prop.getProperty("movie");
        boolean validateSearch = homePage.searchMovie(movieName);
        Assert.assertTrue(validateSearch);
        logger.info("search movie test ended");
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the user can click on the Offer button and validate its functionality")
    @Feature("Offer Button Functionality")
    @Story("User clicks on the offer button and checks if it functions correctly")
    public void OfferButtonTest() {
        logger.info("offer button test started");
        boolean validateOfferButton = homePage.OfferButton();
        Assert.assertTrue(validateOfferButton);
        logger.info("offer button test ended");
    }


    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the page title is correct")
    @Feature("Page Title Validation")
    @Story("User validates that the page title is correct")
    public void isPageTitleCorrectTest() {
        logger.info("page title test started");
        String expectedTitle = "PVR Cinemas";
        Assert.assertEquals(homePage.isPageTitleCorrect(), expectedTitle);
        logger.info("page title test ended");
    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
