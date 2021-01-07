package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;
    final int DefaultTimeOut = 60;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        if(driver!=null)
        {
            wait = new WebDriverWait(driver, DefaultTimeOut);
        }
    }

    public void clickOn(By locator)
    {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }
    }
}
