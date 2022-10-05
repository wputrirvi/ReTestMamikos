package Mamikos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelpers;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;

public class TenantSelectKos extends SeleniumHelpers {
    public TenantSelectKos(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[5]/div/div[1]/div/div/h2")
    WebElement kosListing;
    @FindBy(xpath = "(//div[@class='col-12'])[10]")
    WebElement kosSelected;

    public void seeKosListing() throws InterruptedException {
        Thread.sleep(5000);
        String verifyKosListing = getTextElement(kosListing);
        assertEquals("Ditemukan 290 kos-kosan di sekitar Tobelo, Kabupaten Halmahera Utara, Maluku Utara, Indonesia", verifyKosListing);
    }
    public void clickOnTenthKos() {
        kosSelected.click();
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
    }
}
