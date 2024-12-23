package steps;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class geeksforgeeks_stepdef  {

    public  static WebDriver driver;


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


    @Given("Launch GeeksForGeeks landing page")

    public void launch_geeks_for_geeks_landing_page() {

//            driver = base.getDriver();
            driver.get("https://www.geeksforgeeks.org/");

    }

    @When("Clicking on Pythin link")
    public void clicking_on_pythin_link() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"secondarySubHeader\"]/ul/li[7]/a")).click();
            Thread.sleep(10000);
    }
    @Then("Page for Python Tutorial lands")
    public void page_for_python_tutorial_lands() {
        String title = driver.getTitle();
        String expected = "Python Tutorial | Learn Python Programming Language (2024)";
        Assert.assertEquals(expected,title);
        driver.close();
    }


    @When("Hovering on Courses Menu")
    public void hovering_on_courses_menu() {

        WebElement webElement1 = driver.findElement(By.xpath("//div[text()='Courses']"));
        Actions action = new Actions(driver);
       action.moveToElement(webElement1).perform();
        WebElement webElement2 = driver.findElement(By.xpath("//*[text()='For Students']"));
        action.moveToElement(webElement2).perform();

    }
    @Then("For Student submenu should have Data Science \\(Live) link")
    public void for_student_submenu_should_have_data_science_live_link() {
        WebElement webElement3 = driver.findElement(By.xpath("//*[text()='Data Science (Live)']"));

        String actual = webElement3.getText();
        System.out.println("#######################");
        System.out.println(actual);
        System.out.println("#######################");
    }

}
