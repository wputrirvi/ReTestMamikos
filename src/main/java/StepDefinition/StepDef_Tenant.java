package StepDefinition;

import Mamikos.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.SeleniumHelpers;

import java.util.concurrent.TimeUnit;

public class StepDef_Tenant {
    WebDriver driver;
    MamikosHomePage objMamikosHomePage;
    MamikosLogin objMamikosLogin;
    TenantSearchKos objTenantSearchKos;
    TenantSelectKos objTenantSelectKos;
    Favorite objFavorite;
    SeleniumHelpers objSeleniumHelpers;
    private java.lang.String verifyKostTitle;

    @Given("tenant on jambu page")
    public void tenantOnJambuPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        System.out.println("Test starts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://jambu.kerupux.com/");
        objMamikosHomePage = new MamikosHomePage(driver);
        objMamikosLogin = new MamikosLogin(driver);
        objTenantSelectKos = new TenantSelectKos(driver);
        objTenantSearchKos = new TenantSearchKos(driver);
        objFavorite = new Favorite(driver);
        objSeleniumHelpers = new SeleniumHelpers(driver);
        objMamikosHomePage.verifyHeader();
    }

    @When("tenant click login tab")
    public void tenantClickLoginTab() {
        objMamikosHomePage.clickOnMasukButton();
        objMamikosLogin.clickOnTenant();
    }

    @And("tenant fill in valid username")
    public void tenantFillInValidUsername() {
        objMamikosLogin.enterUsername("082255251112");
    }

    @And("tenant fill in valid password")
    public void tenantFillInValidPassword() {
        objMamikosLogin.enterPassword("12345678");
    }

    @Then("tenant will direct to tenant homepage")
    public void tenantWillDirectToTenantHomepage() {
        objMamikosLogin.clickOnLoginButton();
    }

    @And("tenant search (.*)$")
    public void tenantSearchAreaKost(String areaKost) throws InterruptedException {
        Thread.sleep(3000);
        objTenantSearchKos.clickOnSearchBar();
        objTenantSearchKos.enterSearchKos(areaKost);
        objTenantSearchKos.areaKosResult();
    }

    @And("tenant will see area kost listing")
    public void tenantWillSeeAreaKostListing() throws InterruptedException {
        objTenantSelectKos.seeKosListing();
    }

    @And("tenant open tenth kost on the listing")
    public void tenantOpenTenthKostOnTheListing() {
        objTenantSelectKos.clickOnTenthKos();
    }

    @And("tenant click favorite")
    public void tenantClickFavorite() throws InterruptedException {
        objFavorite.clickOnFavoriteButton();
    }

    @And("tenant open favorite menu")
    public void tenantOpenFavoriteMenu() throws InterruptedException {
        objFavorite.clickOnFavoriteMenu();
    }

    @And("tenant will see the kost favorited")
    public void tenantWillSeeTheKostFavorited() {
        Assert.assertEquals(verifyKostTitle, objFavorite.verifyKosTitle());
        System.out.println(verifyKostTitle);
    }

    @And("tenant open the last favorited kost")
    public void tenantOpenTheLastFavoritedKost() {
        objFavorite.favoritedKos();
    }

    @And("tenant unfavorite the kost")
    public void tenantUnfavoriteTheKost() {
        objFavorite.clickOnUnfavoriteButton();
    }

    @Then("the kost unfavorited")
    public void theKostUnfavorited() {
        objFavorite.verifyUnfavorited();
        driver.quit();
    }
}
