package stepDefinition.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp(){
        ChromeOptions Options = new ChromeOptions();
        String Path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver" , Path);
        driver = new ChromeDriver(Options);
    }

    @After
    public void tearDown(){
        driver.quit();}


}
