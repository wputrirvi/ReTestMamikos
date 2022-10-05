package Mamikos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelpers;

import static org.testng.AssertJUnit.assertEquals;

public class MamikosHomePage extends SeleniumHelpers {
    public MamikosHomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[@class='home-top-search-subtitle']")
    WebElement header;
    @FindBy(xpath = "//*[@id=\"globalNavbar\"]/div/button")
    WebElement masukButton;

    public void verifyHeader(){
        String getHeaderText = header.getText();
        assertEquals("Dapatkan infonya dan langsung sewa di Mamikos.", getHeaderText);
    }
    public void clickOnMasukButton(){
        masukButton.click();
    }
}
