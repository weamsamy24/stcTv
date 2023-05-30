package stepDefinition.steps;

import Locators.US2_Kuwait_Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class US2_Kuwait_Page {

    public WebDriver driver=Hooks.driver;

    /***
     * First SC: Validate to select Kuwait country
     */
    @Given("Navigate to HomePage stvTv")
    public void stcHomePage() {
        driver.navigate().to("https://subscribe.stctv.com/bh-en");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Then("Select Kuwait country")
    public void CountrySelectionFORkw(){
        US2_Kuwait_Locators CountrySelection=new US2_Kuwait_Locators(driver);
        CountrySelection.CountrySelectionFromAList(driver).click();
        CountrySelection.SelectKuwait(driver).click();
        // Assert to Verify the right selection
        String ExpectedResult="Kuwait";
        String ActualResult=CountrySelection.AssertAfterSelection(driver).getText();
        System.out.println("Country name selection is:"+ActualResult);
        Assert.assertEquals(ExpectedResult,ActualResult);
    }


    @And("Validate for the plan types Lite,Classic,premium for Kuwait")
    public void PlanTypeForKuwait(){
        US2_Kuwait_Locators PlanType=new US2_Kuwait_Locators(driver);
        PlanType.PlanTypes(driver);
        try{
            Assert.assertEquals(PlanType.ExpectedResultForPlanTypeInKuwait, PlanType.ActualResultForPlanTypeInKuwait);
            System.out.println("Expected and actual lists are equals");
        }catch(Throwable e){
            System.err.println("Lists are not equal. "+e.getMessage());
        }
    }


    @And("Validate for the price and currency for Kuwait")
    public void ValidateForPriceAndCurrencyForKW(){
        US2_Kuwait_Locators PriceAndCurrency=new US2_Kuwait_Locators(driver);
        /**
         * Price and currency for LITE pack
         */
        String ActualResult=PriceAndCurrency.PriceForLitePack(driver).getText();
        String ExpectedResult="1.2 KWD/month";
        Assert.assertEquals(ActualResult,ExpectedResult);

        /**
         * Price and currency for Classic pack
         */
        String actualResult=PriceAndCurrency.PriceForClassicPack(driver).getText();
        String expectedResult="2.5 KWD/month";
        Assert.assertEquals(actualResult,expectedResult);

        /**
         * Price and currency for Classic pack
         */
        String actual_Result=PriceAndCurrency.PriceForPremiumPack(driver).getText();
        String expected_Result="4.8 KWD/month";
        Assert.assertEquals(actual_Result,expected_Result);

    }


}
