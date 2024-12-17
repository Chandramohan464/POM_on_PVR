package com.pvr.qa.testcases;

import com.pvr.qa.base.BaseClass;
import com.pvr.qa.pages.ShowTimingsPage;
import com.pvr.qa.util.TestUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;


public class ShowTimingsPageTest extends BaseClass {

    ShowTimingsPage showTimingsPage;
    String sheetName="TimeSheet";
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
    public void tommorowShowTimingTest(){

        logger.info("tommorow show timing test started");
        showTimingsPage.tommorowShowTiming();
        logger.info("tommorow show timing test ended");
    }

    @Test(priority = 2)
    public void showTimingsTest(){

        logger.info("show timing test started");
        List<String> showTimings=showTimingsPage.showTimings();
        System.out.println("List of Show's: "+showTimings);
        logger.info("show timing test ended");
    }

    @Test(priority = 3)
    public void countShowsTest(){

        logger.info("count show test started");
        int count=showTimingsPage.countShows();
        Assert.assertEquals(count, 16);
        logger.info("count show test ended");
    }

    @Test(priority = 4)
    public void findShowByTimeTest(){

        logger.info("find show by time test started");
        String time=prop.getProperty("time");
        boolean showIsThere=showTimingsPage.findShowByTime(time);
        System.out.println("Show is present: "+showIsThere);
        logger.info("count show test ended");
    }

    @DataProvider
    public Object[][] getPVRTestData() throws IOException {

        Object data[][]= TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 5,dataProvider = "getPVRTestData")
    public void findShowByTimeDataTest(String time){

        logger.info("find show by time test started using xlsx data");
        boolean showIsThere=showTimingsPage.findShowByTimeData(time);
        System.out.println("Show is present: "+showIsThere);
        logger.info("count show test ended");
    }

    @Test(priority = 6)
    public void countShowsinSevenTest(){

        logger.info("count show's in 7 km test started");
        int count=showTimingsPage.countShowsinSeven();
        System.out.println("Show's in seven KM range: "+count);
        logger.info("count show test ended");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
