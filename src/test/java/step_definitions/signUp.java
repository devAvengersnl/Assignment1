package step_definitions;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class signUp {


    @Before
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    WebDriver driver = null;

    @Given("User with valid url")
    public void user_with_valid_url() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.phptravels.net/register");
    }

    @When("User fill all the details")
    public void user_fill_all_the_details() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("me");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("you");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("ag8j@gmail.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("password");
        driver.findElement(By.cssSelector("[name='confirmpassword']")).sendKeys("password");
    }

    @When("Submit the form")
    public void submit_the_form() {
        driver.findElement(By.cssSelector(".signupbtn")).click();
    }

    @Then("User get registered")
    public void user_get_registered() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.getCurrentUrl().contains("/account/");

    }

    @Then("User is  able to see his name  on dashboard")
    public void user_is_able_to_see_his_name_on_dashboard() {
        driver.findElement(By.cssSelector(".RTL.go-right")).getText().contains("me");
    }













}
