package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

public class SeleniumHelpers {
    private final WebDriverWait wait;
    protected final WebDriver driver;

    public SeleniumHelpers(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    protected void waitToBeClickable(WebElement webElement){
        try {
            waitVisibilityElement(webElement);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void waitVisibilityElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitPressenceOfElement(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected boolean isElementDisplayed(WebElement webElement){
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    protected void clickElement(WebElement webElement) {
        waitToBeClickable(webElement);
        webElement.click();
    }

    protected String getTextElement(WebElement webElement) {
        waitVisibilityElement(webElement);
        return webElement.getText();
    }

    protected void scrollTo(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected void scrollClick(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        js.executeScript("arguments[0].click();", webElement);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
    }

    public void sendAttachment(String theFile) throws Exception {
        Robot rb = new Robot();
        StringSelection strSel = new StringSelection(theFile);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null); //save/copy the file

        rb.delay(1000);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}
