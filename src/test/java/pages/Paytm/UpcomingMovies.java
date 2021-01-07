package pages.Paytm;

import Utils.BasePage;
import Utils.Config;
import Utils.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class UpcomingMovies extends BasePage {

    static String api_URl = "";
    static Response resp;
    static int size;
    Config cfg = new Config();

    public UpcomingMovies(WebDriver driver) throws IOException {
        super(driver);
    }

    @Given("^API URL to fetch upcoming movies in paytm$")
    public void apiURLToFetchUpcomingMoviesInPaytm() {
        System.out.println("Test working or not");
        System.out.println("Step executing" );
        api_URl = cfg.getProperty("URL_Upcoming_Movies");
        System.out.println(api_URl);

    }

    @When("^I send GET request to fetch upcoming movies$")
    public void iSendGETRequestToFetchUpcomingMovies() {
        resp = RestAssured.given().get(api_URl);
        size = resp.jsonPath().getList("upcomingMovieData").size();
        Reporter.assertThat(resp.getStatusCode(),200,"","Status code Failed");

       }
}
