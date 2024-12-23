package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SearchPageStepdefs {
    public static WebDriver driver;
    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
    }
@After
public void teardown(){
        driver.quit();
}

    @Given("Launch Google search page")
    public void Launch_Google_search_page() throws InterruptedException {

        driver.get("https://www.google.com/");
        Thread.sleep(10000);
        driver.switchTo().frame("callout");
        driver.findElement(By.xpath("//button[@aria-label='Stay signed out']")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(10000);
    }

    @When("^Enter the \"([^\"]*)\" in searchbox$")
    public void Enter_the_text_in_searchbox(String text) throws InterruptedException {


            WebElement element = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
            element.sendKeys(text);
            Thread.sleep(5000);
            String actual = element.findElement(By.xpath("(//*[@role='listbox']/li)[1]")).getText();
            Assert.assertEquals(text,actual);


    }

    @Then("Entered text should match the actual text")
    public void Entered_text_should_match_the_actual_text(){

    }
    @When("Click on Sign in link")
    public void Click_on_Sign_in_link() throws InterruptedException {
        Thread.sleep(5000);
        WebElement element1 = driver.findElement(By.xpath("//*[@id='gb']/div/div[2]/a"));
        element1.click();
    }

    @Then("Navigate to Sign in page")
    public void Navigate_to_Sign_in_page () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        String expected = "Sign in - Google Accounts";
        wait.until(ExpectedConditions.titleContains(expected));
        String actual = driver.getTitle();
        Assert.assertEquals(expected,actual);
    }


}
