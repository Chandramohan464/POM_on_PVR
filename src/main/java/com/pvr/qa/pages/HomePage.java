package com.pvr.qa.pages;

import com.pvr.qa.base.BaseClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//div[@class='show-desktop-view']")
    WebElement locationDropdown;

    @FindBy(xpath = "//input[@placeholder='Search for city']")
    WebElement locationSearchBox;

    @FindBy(xpath = "//i[@class='pi pi-search']")
    WebElement locationButton;

    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement searchBox;

    @FindBy(xpath = "//div[@class='search-icon-main-nav']//img[@class='img-fluid']")
    WebElement searchButton;

    @FindBy(xpath = "//img[@class='logos-pvr']")
    WebElement pvrImage;

    @FindBy(xpath = "//div[@class='useful-link'][contains(text(),'Offers')]")
    WebElement offerButton;

    public HomePage(){

        PageFactory.initElements(driver,this);
        logger.info("HomePage initialized with WebDriver.");
    }

    public boolean checkImageDisplay(){

        logger.info("Checking for display image");
        return pvrImage.isDisplayed();
    }

    public void selectLocation(String location) throws InterruptedException {

        logger.info("clicking on location drop-down");
        locationDropdown.click();
        logger.info("Entering location: "+location);
        locationSearchBox.sendKeys(location);
        Thread.sleep(2000);
    }

    public void selectLocationData(String location) throws InterruptedException {

        logger.info("clicking on location drop-down");
        locationDropdown.click();
        logger.info("Entering location: "+location);
        locationSearchBox.sendKeys(location);
        Thread.sleep(2000);
    }

    public boolean searchMovie(String name){

        logger.info("Entering movie name: "+name);
        searchBox.sendKeys(name);
        logger.info("clicking on movie");
        driver.findElement(By.xpath("//div[@class='search-icon-main-nav']//img[@class='img-fluid']")).click();
        driver.findElement(By.xpath("//h6[contains(.,'PUSHPA(THE RULE PART-02)')]")).click();
        String actualURL =driver.getCurrentUrl();
        return "https://www.pvrcinemas.com/moviesessions/-Bengaluru/PUSHPA(THE%20RULE%20PART-02)/28540".equals(actualURL);
    }

    public boolean OfferButton(){

        logger.info("Clicking on offer button");
        offerButton.click();
        String actualURL =driver.getCurrentUrl();
        return "https://www.pvrcinemas.com/offers".equals(actualURL);
    }

    public String isPageTitleCorrect() {

        logger.info("checking for page title");
        String actualTitle = driver.getTitle();
        return actualTitle;
    }
}


