package com.pvr.qa.testcases;

import com.pvr.qa.base.BaseClass;
import com.pvr.qa.pages.OffersPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class OffersPageTest extends BaseClass {

    OffersPage offersPage;
    private static final Logger logger = LogManager.getLogger(OffersPageTest.class);

    public OffersPageTest(){

        super();
    }

    @BeforeMethod
    public void setUp(){

        initialize();
        offersPage = new OffersPage();
    }

    @Test(priority = 1)
    public void offersPageTest(){

        logger.info("offer page test started");
        offersPage=offersPage.checkOfferPageDisplay();
        logger.info("offer page test ended");
    }

    @Test(priority = 2)
    public void offersCountTest(){

        logger.info("offer count test started");
        offersPage.offersCount();
        logger.info("offer count test ended");
    }

    @Test(priority = 3)
    public void offerDetailsTest(){

        logger.info("offer detail test started");
        offersPage.offerDetails(5);
        logger.info("offer detail test ended");
    }

    @Test(priority = 4)
    public void getOfferTitleTest(){

        logger.info("get offer title test started");
        String actual=offersPage.getOfferTitle(10);
        System.out.println("Title of the Offer is: "+actual);
        logger.info("get offer title test ended");
    }

    @Test(priority = 5)
    public void viewTermsAndConditionsTest() throws InterruptedException {

        logger.info("view terms and condition test started");
        offersPage.viewTermsAndConditions(3);
        logger.info("view terms and condition test ended");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
