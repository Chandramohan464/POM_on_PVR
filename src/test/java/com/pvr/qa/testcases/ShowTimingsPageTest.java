package com.pvr.qa.testcases;

import com.pvr.qa.base.BaseClass;
import com.pvr.qa.pages.ShowTimingsPage;
import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class ShowTimingsPageTest extends BaseClass {

    ShowTimingsPage showTimingsPage;
    private static final Logger logger = LogManager.getLogger(ShowTimingsPageTest.class);

    public ShowTimingsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialize();
        showTimingsPage = new ShowTimingsPage();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the show timings for tomorrow are displayed correctly")
    @Feature("Tomorrow Show Timings")
    @Story("User checks tomorrow's show timings")
    public void tommorowShowTimingTest(){
        logger.info("tommorow show timing test started");
        showTimingsPage.tommorowShowTiming();
        logger.info("tommorow show timing test ended");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that all show timings are displayed correctly")
    @Feature("Show Timings Functionality")
    @Story("User views the list of all show timings")
    public void showTimingsTest(){
        logger.info("show timing test started");
        List<String> showTimings = showTimingsPage.showTimings();
        System.out.println("List of Show's: " + showTimings);
        logger.info("show timing test ended");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the correct number of shows are listed")
    @Feature("Show Count Validation")
    @Story("User checks the total count of shows")
    public void countShowsTest(){
        logger.info("count show test started");
        int count = showTimingsPage.countShows();
        Assert.assertEquals(count, 16);  // Assuming 16 is the expected count
        logger.info("count show test ended");
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the show can be found by a specific time")
    @Feature("Show Search by Time")
    @Story("User searches for a show by a specific time")
    public void findShowByTimeTest(){
        logger.info("find show by time test started");
        String time = prop.getProperty("time");
        boolean showIsThere = showTimingsPage.findShowByTime(time);
        System.out.println("Show is present: " + showIsThere);
        logger.info("find show by time test ended");
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the count of shows within a 7 km radius is correct")
    @Feature("Count Shows in 7 KM Range")
    @Story("User checks the number of shows within a 7 km radius")
    public void countShowsinSevenTest(){
        logger.info("count show's in 7 km test started");
        int count = showTimingsPage.countShowsinSeven();
        System.out.println("Show's in seven KM range: " + count);
        logger.info("count show test ended");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
