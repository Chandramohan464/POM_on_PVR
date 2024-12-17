package com.pvr.qa.testcases;

import com.pvr.qa.base.BaseClass;
import com.pvr.qa.pages.HomePage;
import com.pvr.qa.util.TestUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class HomePageTest extends BaseClass {

    HomePage homePage;
    String sheetName="LocationSheet";
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
    public void checkImageDisplayTest(){

        logger.info("check image test started");
        boolean validateImage=homePage.checkImageDisplay();
        Assert.assertTrue(validateImage);
        logger.info("check image test ended");
    }

    @Test(priority = 2)
    public void selectLocationTest() throws InterruptedException {

        logger.info("select location test started");
        String location=prop.getProperty("location");
        homePage.selectLocation(location);
        logger.info("select location test ended");
    }

    @DataProvider
    public Object[][] getPVRTestData() throws IOException {

        return TestUtil.getTestData(sheetName);
    }

    @Test(priority = 3,dataProvider = "getPVRTestData")
    public void selectLocationDataTest(String location) throws InterruptedException {

        logger.info("select location test started using xlsx sheet");
        homePage.selectLocationData(location);
        logger.info("select location test ended using xlsx sheet");
    }

    @Test(priority = 4)
    public void searchMovieTest(){

        logger.info("search movie test started");
        String movieName =prop.getProperty("movie");
        boolean validateSearch=homePage.searchMovie(movieName);
        Assert.assertTrue(validateSearch);
        logger.info("search movie test ended");
    }

    @Test(priority = 5)
    public void OfferButtonTest(){

        logger.info("offer button test started");
        boolean validateOfferButton=homePage.OfferButton();
        Assert.assertTrue(validateOfferButton);
        logger.info("offer button test ended");
    }

    @Test(priority = 6)
    public void isPageTitleCorrectTest(){

        logger.info("page title test started");
        String expectedTitle="PVR Cinemas";
        Assert.assertEquals(homePage.isPageTitleCorrect(),expectedTitle);
        logger.info("page title test ended");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
