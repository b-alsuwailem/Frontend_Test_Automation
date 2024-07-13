package Tests.SubscriptionPlansSA.PremiumPlanSA;

import Pages.SubscriptionPlans;
import Resources.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PremiumPackageCurrencySA {
    private WebDriver driver;
    private SubscriptionPlans subscriptionPlans;
    private String actuaPremiumPackageCurrencyEN;
    private String actuaPremiumPackageCurrencyAR;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects
        subscriptionPlans = new SubscriptionPlans(driver);
        //
        actuaPremiumPackageCurrencyEN = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_SA_EN;
        actuaPremiumPackageCurrencyAR = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_SA_AR;
    }
    //
    @Test
    public void testPremiumPackagesCurrencyEN() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Verify Lite Packages Currency
        subscriptionPlans.checkPremiumCurrencyPriceEN(actuaPremiumPackageCurrencyEN);
    }
    //
    @Test
    public void testPremiumPackagesCurrencyAR() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscriptionPlans.changeToArabic();
        // Verify Lite Packages Currency
        subscriptionPlans.checkPremiumCurrencyPriceAR(actuaPremiumPackageCurrencyAR);
    }
    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}