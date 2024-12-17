package com.pvr.qa.pages;

import com.pvr.qa.base.BaseClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CinemasPage extends BaseClass {

    private static final Logger logger = LogManager.getLogger(CinemasPage.class);

    @FindBy(xpath = "//div[contains(text(),'Cinemas')]")
    WebElement cinemasButton;

    @FindBy(xpath = "(//div[@class='cinema-list'])")
    List<WebElement> collectionOfTheaters;

    @FindBy(xpath = "//span[@class='date-inactive pointer']")
    WebElement experiencesButton;

    @FindBy(xpath = "//input[@placeholder='Search for cinema']")
    WebElement searchBar;

    @FindBy(xpath = "//h2[contains(text(),'PVR')]")
    List<WebElement> pvrCinemasCollection;

    @FindBy(xpath = "//p[starts-with(text(),'7.')]")
    List<WebElement> cinemasUnderSevenKM;

    public CinemasPage(){

        PageFactory.initElements(driver,this);
        logger.info("HomePage initialized with WebDriver.");
    }

    public void numberOfTheaters(){

        logger.info("Clicking on cinemas button");
        cinemasButton.click();
        logger.info("Checking number of theater's");
        int count=collectionOfTheaters.size();
        System.out.println("Number of theater's: "+count);
    }

    public boolean checkForDisplayOfExperiences(){

        logger.info("Clicking on cinemas button");
        cinemasButton.click();
        logger.info("Clicking on experience button");
        experiencesButton.click();
        logger.info("checking for correct result");
        String url=driver.getCurrentUrl();
        return("https://www.pvrcinemas.com/experience/Bengaluru".equals(url));
    }

    public void checksearchBarIsDisplayed(){

        logger.info("Clicking on cinemas button");
        cinemasButton.click();
        logger.info("Checking for display image");
        searchBar.isDisplayed();
    }

    public void countPVRCinema(){

        logger.info("Clicking on cinemas button");
        cinemasButton.click();
        logger.info("Counting number of PVR cinema's");
        int count=pvrCinemasCollection.size();
        System.out.println("Total PVR cinema's: "+count);
    }

    public void totalCinemasUnderSeven(){

        logger.info("Clicking on cinemas button");
        cinemasButton.click();
        logger.info("Counting number of PVR cinema's under 7 km");
        System.out.println("Total number of cinemas under seven KM: "+cinemasUnderSevenKM.size());
    }
}
