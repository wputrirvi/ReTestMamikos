package Mamikos;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.SeleniumHelpers;

import java.util.ArrayList;


public class Favorite extends SeleniumHelpers {
    public Favorite(WebDriver driver){
        super(driver);
    }

    //**Favorite Repository
    @FindBy(xpath = "//button[@class='bg-c-button detail-kost-additional-widget__outer bg-c-button--tertiary bg-c-button--md track-favorite']")
    WebElement favoriteButton;
    @FindBy(xpath = "//button[@class='bg-c-button detail-kost-additional-widget__outer bg-c-button--tertiary bg-c-button--md detail-kost-additional-widget__outer--favorited']")
    WebElement unfavoriteButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[6]/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/span[1]")
    WebElement kosTitle;
    @FindBy(xpath = "//*[@id=\"globalNavbar\"]/ul/li[1]")
    WebElement MenuFavorite;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[6]/div/div[1]/div[2]/div/div/div[2]/div/div[2]")
    WebElement lastFavoriteKos;
    @FindBy(xpath = "//div[@class='stats-not-found']")
    WebElement unfavorited;

    //** PopUp Repository
    @FindBy(xpath = "//button[@class='btn-next btn-primary']")
    WebElement lanjutPopUpButton;
    @FindBy(xpath = "//button[@class='btn-primary swiper-button-disabled']")
    WebElement sayaMengertiButton;

    public void clickOnFavoriteButton() throws InterruptedException {
        scrollTo(favoriteButton);
        Thread.sleep(3000);
        int i = 1;
        while (i < 6) {
            lanjutPopUpButton.click();
            i++;
        }
        clickElement(sayaMengertiButton);
        scrollClick(favoriteButton);
    }
    public void clickOnFavoriteMenu() throws InterruptedException {
        clickElement(MenuFavorite);
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(2));
        Thread.sleep(1000);
        String favoritePage = driver.getTitle();
        Assert.assertEquals("Histori Kost Favorit - Mamikos", favoritePage);
    }
    public Object verifyKosTitle(){
        getTextElement(kosTitle);
        return null;
    }

    public void favoritedKos() {
        clickElement(lastFavoriteKos);
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(3));
    }

    public void clickOnUnfavoriteButton() {
        scrollClick(unfavoriteButton);
        clickElement(MenuFavorite);
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(4));
    }

    public void verifyUnfavorited() {
        isElementDisplayed(unfavorited);
        System.out.println("Kost Successfully Unfavorited!");
    }

}
