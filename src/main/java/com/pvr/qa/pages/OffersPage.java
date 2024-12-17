package com.pvr.qa.pages;

import com.pvr.qa.base.BaseClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OffersPage extends BaseClass {

    private static final Logger logger = LogManager.getLogger(OffersPage.class);

    @FindBy(xpath = "//div[@class='useful-link'][text()='Offers']")
    WebElement offerButton;

    @FindBy(xpath = "//div[@class='row mt-3']//div[1]//div[1]//div[1]")
    List<WebElement> offers;

    @FindBy(xpath="//h4[text()='Terms and Conditions']")
    WebElement termsAndConditions;

    public OffersPage(){

        PageFactory.initElements(driver,this);
        logger.info("Offer'sPage initialized with WebDriver.");
    }

    public OffersPage checkOfferPageDisplay(){

        logger.info("clicking on offer's button");
        offerButton.click();
        return new OffersPage();
    }

    public int offersCount(){

        logger.info("clicking on offer's button");
        offerButton.click();
        logger.info("conting no of offers");
        return offers.size();
    }

    public void offerDetails(int index){

        logger.info("clicking on offer's button");
        offerButton.click();
        logger.info("getting offer detail");
        offers.get(index).click();
    }

    public String getOfferTitle(int index){

        logger.info("clicking on offer's button");
        offerButton.click();
        logger.info("getting offer detail");
        return offers.get(index).getText();
    }

    public void viewTermsAndConditions(int index) throws InterruptedException {

        logger.info("clicking on offer's button");
        offerButton.click();
        logger.info("checking for terms and condition");
        offers.get(index).click();
        Thread.sleep(5000);
    }
}
