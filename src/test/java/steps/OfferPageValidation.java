package steps;

import com.pvr.qa.base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OfferPageValidation extends BaseClass {
    public OfferPageValidation(){
        super();
    }

    @Given("User should be in home page")
    public void UserShouldBeInHomePage() {
        initialize();
    }

    @When("User clicks the offer button")
    public void UserClicksTheOfferButton() {
        WebElement offerButton=driver.findElement(By.xpath("//div[@class='useful-link'][contains(text(),'Offers')]"));
        offerButton.click();
    }

    @Then("User should navigated to offer page")
    public void UserShouldNavigatedToOfferPage() {
        String title=driver.findElement(By.xpath("//h1[text()='Offers']")).getText();
        Assert.assertEquals(title,"Offers");
    }
}
