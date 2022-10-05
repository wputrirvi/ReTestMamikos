package Mamikos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelpers;

public class TenantSearchKos extends SeleniumHelpers {
    public TenantSearchKos(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='btn-cta-search']")
    WebElement searchBar;
    @FindBy(xpath = "//input[@type='search']")
    WebElement searchBarTop;
    @FindBy(xpath = "//*[@id=\"suggestionsBox\"]/div/div[2]/a[1]")
    WebElement searchResult;

    public void clickOnSearchBar() {
        clickElement(searchBar);
    }
    public void enterSearchKos(String areaKost){
        searchBarTop.sendKeys(areaKost);
    }
    public void areaKosResult(){
        searchResult.click();
    }
}
