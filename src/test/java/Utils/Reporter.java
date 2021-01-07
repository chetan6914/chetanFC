package Utils;

import cucumber.api.Scenario;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Reporter {

    public static SoftAssertions softAssertions;

    public Reporter()
    {
        softAssertions = new SoftAssertions();
    }

    public static void assertThat(Object actual, Object expected)
    {
        Reporter.softAssertions.assertThat(actual).isEqualTo(expected);
    }

    public static void assertThat(Object actual, Object expected, String TestcaseID)
    {
        Reporter.softAssertions.assertThat(actual).isEqualTo(expected).as(TestcaseID);
    }

    public static void assertThat(Object actual, Object expected, String TestcaseID, String Description)
    {
        Reporter.softAssertions.assertThat(actual).isEqualTo(expected).as("TestCaseID : " + TestcaseID + " --> " + Description);
    }


    public WebDriver driver;

    @Before
    public void init(Scenario scenario)
    {
        softAssertions = new SoftAssertions();
        if(scenario.getSourceTagNames().contains("@API"))
        {
            getBrowser();
        }
    }

    public WebDriver getBrowser()
    {
        if(System.getenv("Env") != null)
        {
            Config.Browser = System.getenv("Browser");
        }
        if(Config.Browser.equalsIgnoreCase("Chrome"))
        {
            this.driver = getChromeBrowser();
        }
        if(Config.Browser.equalsIgnoreCase("API"))
        {
            this.driver = null;
        }
        return driver;
    }

    private WebDriver getChromeBrowser()
    {
        File file = null;
        file = new File("src/test/resoruces/Drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        return driver;
    }


}
