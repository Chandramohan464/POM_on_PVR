package com.pvr.qa.pages;

import com.pvr.qa.base.BaseClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ShowTimingsPage extends BaseClass {

    private static final Logger logger = LogManager.getLogger(ShowTimingsPage.class);

    @FindBy(xpath = "//div[text()='Showtimings']")
    WebElement showTimingButton;

    @FindBy(xpath = "//h5[text()='17']")
    WebElement date;

    @FindBy(xpath = "//div[@class='show-times']")
    List<WebElement> showTimings;

    @FindBy(xpath = "//span[contains(text(),'7.')]")
    List<WebElement> cinemasInSeven;

    public ShowTimingsPage(){

        PageFactory.initElements(driver,this);
        logger.info("Show timing page Page initialized with WebDriver.");
    }

    public void tommorowShowTiming(){

        logger.info("clicking on timing button");
        showTimingButton.click();
        logger.info("checking for movie's");
        date.click();
    }

    public List<String> showTimings(){

        logger.info("clicking on timing button");
        showTimingButton.click();
        List<String> list = new ArrayList<>();
        for (WebElement element : showTimings) {
            String text = element.getText();
            list.add(text);
        }
        logger.info("displaying show timing's");
        return list;
    }

    public int countShows(){

        logger.info("clicking on timing button");
        showTimingButton.click();
        logger.info("counting number of show's");
        int totalShows=showTimings.size();
        System.out.println("Total no of Show's: "+totalShows);
        return totalShows;
    }

    public boolean findShowByTime(String time){

        logger.info("clicking on timing button");
        showTimingButton.click();
        for (WebElement ele:showTimings){
            if(ele.getText()==time){
                return true;
            }
        }
        return false;
    }

    public boolean findShowByTimeData(String time){

        logger.info("clicking on timing button");
        showTimingButton.click();
        for (WebElement ele:showTimings){
            if(ele.getText()==time){
                return true;
            }
        }
        return false;
    }

    public int countShowsinSeven(){

        logger.info("clicking on timing button");
        showTimingButton.click();
        logger.info("checking show's in 7 km range");
        return cinemasInSeven.size();
    }
}
