package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US2_Kuwait_Locators {

    public static WebDriver driver;
    public static WebElement element=null;
    //Lists to compare between Plan types
    public List<String> ExpectedResultForPlanTypeInKuwait = Arrays.asList("LITE", "CLASSIC", "PREMIUM");
    public List<String> ActualResultForPlanTypeInKuwait = new ArrayList<>();



    public US2_Kuwait_Locators(WebDriver driver){
        this.driver=driver;
    }

    //Select the country from home page
    public WebElement CountrySelectionFromAList(WebDriver driver){
        element=driver.findElement(By.xpath("//div[@class=\"country-current\"]"));
        return element;
    }
    //Select KSA country
    public WebElement SelectKuwait(WebDriver driver){
        element=driver.findElement(By.xpath("//span[@id=\"kw-contry-lable\"]"));
        return element;
    }
    //Assert for the right selection
    public WebElement AssertAfterSelection(WebDriver driver){
        element=driver.findElement(By.partialLinkText("Kuwait"));
        return element;
    }
    //Validate for the plans types
    public void PlanTypes(WebDriver driver){
        List<WebElement> elements= driver.findElements(By.xpath("//strong[@class=\"plan-title\"]"));
        System.out.println("Number of elements for Plan Type:" +elements.size());
        for(WebElement element: elements){
            ActualResultForPlanTypeInKuwait.add(element.getText());
        }
        System.out.print(ActualResultForPlanTypeInKuwait);

    }
    //Validate the price for the lite package
    public WebElement PriceForLitePack(WebDriver driver){
        element=driver.findElement(By.xpath("//div[@id=\"currency-lite\"]"));
        return element;
    }
    //Validate the price for the Classic package
    public WebElement PriceForClassicPack(WebDriver driver){
        element=driver.findElement(By.xpath("//div[@id=\"currency-classic\"]"));
        return element;
    }
    //Validate the price for the premium package
    public WebElement PriceForPremiumPack(WebDriver driver){
        element=driver.findElement(By.xpath("//div[@id=\"currency-premium\"]"));
        return element;
    }

}
