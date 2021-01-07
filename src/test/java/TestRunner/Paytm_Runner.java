package TestRunner;

import Utils.Config;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(

        features ={"src\\test\\resources\\Features"},
        format = {"pretty", "html:target/Destination"},
        tags = {"@API"},
        glue = {"Utils", "pages"}
)

public class Paytm_Runner {

    @BeforeClass
    public static void setup() throws IOException {
        Config.Env="QA";
        Config.Module="Paytm";
        Config.Browser="API";
        //       BeforeSuite.init();
    }

/*    @AfterClass
    public static void teardown() throws IOException {
        // AfterSuite.tearDown();
    }*/

}
