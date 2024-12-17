package com.pvr.qa.pages;

import com.pvr.qa.base.BaseClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UpComingFilms extends BaseClass {

    private static final Logger logger = LogManager.getLogger(UpComingFilms.class);

    @FindBy(xpath = "//div[contains(text(),'Coming Soon')]")
    WebElement upComingButton;

    @FindBy(xpath = "(//img[@alt='add to wishlist'])")
    List<WebElement> upComingMovies;

    @FindBy(xpath = "(//b[contains(text(),'Releasing')])")
    List<WebElement> releaseDates;

    @FindBy(xpath = "(//span[@class='see-all'][text()='See all'])[1]")
    WebElement seeAllBtn;

    @FindBy(xpath = "(//img[@alt='add to wishlist'])[1]")
    WebElement addTOWishListBtn;

    public UpComingFilms(){

        PageFactory.initElements(driver,this);
        logger.info("Up-coming film's Page initialized with WebDriver.");
    }

    public void checkUpComingDisplay(){

        logger.info("clicking on button");
        upComingButton.click();
    }

    public int countUpComingMovies(){

        logger.info("clicking on button");
        return upComingMovies.size();
    }

    public void upComingMovieDates(){

        logger.info("clicking on button");
        upComingButton.click();
        logger.info("checking for upcoming movie date's");
        for(WebElement ele:releaseDates){
            System.out.println(ele.getText());
        }
    }

    public void checkSeeAllButton(){

        logger.info("clicking on button");
        upComingButton.click();
        logger.info("checking for image display");
        seeAllBtn.isDisplayed();
    }

    public void checkAddToWishes(){

        logger.info("clicking on button");
        upComingButton.click();
        logger.info("checking for image display");
        addTOWishListBtn.isDisplayed();
    }
}
