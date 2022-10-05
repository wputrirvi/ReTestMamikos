package Mamikos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.SeleniumHelpers;

import java.time.Duration;

public class MamikosLogin extends SeleniumHelpers {
    public MamikosLogin(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"loginModal\"]/div/div/div[2]/div/div[2]/div/div[1]")
    WebElement tenantLogin;
    @FindBy(xpath = "//*[@id=\"loginModal\"]/div/div/div[2]/div/div[2]/div/div[2]")
    WebElement ownerLogin;
    @FindBy(xpath = "//*[@id=\"loginModal\"]/div/div/div[2]/div/div[3]/div/form/fieldset/div[1]/div/input")
    WebElement inputUsername;
    @FindBy(xpath = "//*[@id=\"loginModal\"]/div/div/div[2]/div/div[3]/div/form/fieldset/div[2]/div/input")
    WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"loginModal\"]/div/div/div[2]/div/div[3]/div/form/fieldset/button")
    WebElement loginButton;
    @FindBy(xpath = "//p[contains(.,'Waktunya Mengelola Properti')]")
    WebElement verifyOwnerDashboard;
    @FindBy(xpath = "//*[@id=\"globalNavbar\"]/div/button")
    public WebElement masukButton;

    public void clickOnTenant(){
        tenantLogin.click();
    }
    public void clickOnOwner(){
        ownerLogin.click();
    }
    public void enterUsername(String arg1){
        inputUsername.sendKeys(arg1);
    }
    public void enterPassword(String arg1){
        inputPassword.sendKeys(arg1);
    }
    public void clickOnLoginButton(){
        loginButton.click();
//        Assert.as(false, String.valueOf(masukButton.isDisplayed()));
    }
}
