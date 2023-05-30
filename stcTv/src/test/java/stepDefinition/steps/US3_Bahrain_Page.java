package stepDefinition.steps;

import Locators.US3_Bahrain_Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class US3_Bahrain_Page {
    public  WebDriver driver=Hooks.driver;

    /***
     * First SC: Validate to select the Bahrain country
     */
    @Given("Navigate to Bahrain stvTv")
    public void HomePage() {
        driver.get("https://subscribe.stctv.com/sa-en");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Then("Select Bahrain country")
    public void CountrySelection(){
        US3_Bahrain_Locators CountrySelection=new US3_Bahrain_Locators(driver);
        CountrySelection.CountrySelectionFromAList(driver).click();
        CountrySelection.SelectBahrain(driver).click();
        // Assert to Verify the right selection
        String ExpectedResult="Bahrain";
        String ActualResult=CountrySelection.AssertAfterSelection(driver).getText();
        System.out.println("Country name selection is:"+ActualResult);
        Assert.assertEquals(ExpectedResult,ActualResult);
    }


    @And("Validate for the plan types Lite,Classic,premium for Bahrain")
    public void PlanTypeForBahrain(){
        US3_Bahrain_Locators PlanType=new US3_Bahrain_Locators(driver);
        PlanType.PlanTypes(driver);
        try{
            Assert.assertEquals(PlanType.ExpectedResultForPlanTypeInBahrain, PlanType.ActualResultForPlanTypeInBahrain);
            System.out.println("Expected and actual lists are equals");
        }catch(Throwable e){
            System.err.println("Lists are not equal. "+e.getMessage());
        }
    }

    @And("Validate for the price and currency for Bahrain")
    public void ValidateForPriceAndCurrency(){
        US3_Bahrain_Locators PriceAndCurrency=new US3_Bahrain_Locators(driver);
        /**
         * Price and currency for LITE pack
         */
        String ActualResult=PriceAndCurrency.PriceForLitePack(driver).getText();
        String ExpectedResult="2 BHD/month";
        Assert.assertEquals(ActualResult,ExpectedResult);

        /**
         * Price and currency for Classic pack
         */
        String actualResult=PriceAndCurrency.PriceForClassicPack(driver).getText();
        String expectedResult="3 BHD/month";
        Assert.assertEquals(actualResult,expectedResult);

        /**
         * Price and currency for Classic pack
         */
        String actual_Result=PriceAndCurrency.PriceForPremiumPack(driver).getText();
        String expected_Result="6 BHD/month";
        Assert.assertEquals(actual_Result,expected_Result);

    }

}
