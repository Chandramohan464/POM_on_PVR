package com.pvr.qa.testcases;

import com.pvr.qa.base.BaseClass;
import com.pvr.qa.pages.OffersPage;
import io.qameta.allure.*;
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
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the offers page is displayed correctly")
    @Feature("Offers Page Functionality")
    @Story("User checks if the offers page is displayed correctly")
    public void offersPageTest(){
        logger.info("offer page test started");
        offersPage = offersPage.checkOfferPageDisplay();
        logger.info("offer page test ended");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the correct number of offers are displayed on the offers page")
    @Feature("Offers Count Functionality")
    @Story("User verifies if the offers count is correct")
    public void offersCountTest(){
        logger.info("offer count test started");
        offersPage.offersCount();
        logger.info("offer count test ended");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the offer details are displayed correctly when selecting an offer")
    @Feature("Offer Details Functionality")
    @Story("User views the details of an offer")
    public void offerDetailsTest(){
        logger.info("offer detail test started");
        offersPage.offerDetails(5);  // Passing an example offer index
        logger.info("offer detail test ended");
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the title of an offer is correctly retrieved")
    @Feature("Offer Title Functionality")
    @Story("User retrieves and prints the title of an offer")
    public void getOfferTitleTest(){
        logger.info("get offer title test started");
        String actual = offersPage.getOfferTitle(10);  // Passing an example offer index
        System.out.println("Title of the Offer is: " + actual);
        logger.info("get offer title test ended");
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the terms and conditions for an offer can be viewed")
    @Feature("Terms and Conditions View Functionality")
    @Story("User views the terms and conditions of an offer")
    public void viewTermsAndConditionsTest() throws InterruptedException {
        logger.info("view terms and condition test started");
        offersPage.viewTermsAndConditions(3);  // Passing an example offer index
        logger.info("view terms and condition test ended");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
