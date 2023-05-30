package stepDefinition.steps;

import Locators.US1_KSA_Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class US1_KSA_Page {

    public  WebDriver driver= Hooks.driver;

    /***
     * First SC: Validate to select the KSA country
     */
    @Given("Navigate to stvTv")
    public void HomePage() {
        driver.navigate().to("https://subscribe.stctv.com/bh-en");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Then("Select the country")
    public void CountrySelection(){
        US1_KSA_Locators CountrySelection=new US1_KSA_Locators(driver);
        CountrySelection.CountrySelectionFromAList(driver).click();
        CountrySelection.SelectKSA(driver).click();
        // Assert to Verify the right selection
        String ExpectedResult="KSA";
        String ActualResult=CountrySelection.AssertAfterSelection(driver).getText();
        System.out.println("Country name selection is:"+ActualResult);
        Assert.assertEquals(ExpectedResult,ActualResult);
    }


    @And("Validate for the plan types Lite,Classic,premium for KSA")
    public void PlanTypeForKSA(){
        US1_KSA_Locators PlanType=new US1_KSA_Locators(driver);
        PlanType.PlanTypes(driver);
        try{
            Assert.assertEquals(PlanType.ExpectedResultForPlanTypeInKSA, PlanType.ActualResultForPlanTypeInKSA);
            System.out.println("Expected and actual lists are equals");
        }catch(Throwable e){
            System.err.println("Lists are not equal. "+e.getMessage());
        }
    }

    @And("Validate for the price and currency for KSA")
    public void ValidateForPriceAndCurrency(){
        US1_KSA_Locators PriceAndCurrency=new US1_KSA_Locators(driver);
        /**
         * Price and currency for LITE pack
         */
        String ActualResult=PriceAndCurrency.PriceForLitePack(driver).getText();
        String ExpectedResult="15 SAR/month";
        Assert.assertEquals(ActualResult,ExpectedResult);

        /**
         * Price and currency for Classic pack
         */
        String actualResult=PriceAndCurrency.PriceForClassicPack(driver).getText();
        String expectedResult="25 SAR/month";
        Assert.assertEquals(actualResult,expectedResult);

        /**
         * Price and currency for Classic pack
         */
        String actual_Result=PriceAndCurrency.PriceForPremiumPack(driver).getText();
        String expected_Result="60 SAR/month";
        Assert.assertEquals(actual_Result,expected_Result);

    }
    @And("CloseBrowser")
    public void Close(){
        driver.quit();
    }

}
