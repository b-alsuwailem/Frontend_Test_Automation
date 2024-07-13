package Tests.SubscriptionPlansBH.PremiumPlanBH;

import Pages.SubscriptionPlans;
import Resources.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// Test class for verifying Premium package currency in Bahrain for both English and Arabic
public class PremiumPackageCurrencyBH {
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
        // Set expected currencies for Premium package in English and Arabic
        actuaPremiumPackageCurrencyEN = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_BH_EN;
        actuaPremiumPackageCurrencyAR = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_BH_AR;
    }
    // Test to verify Premium package currency in English for Bahrain
    @Test
    public void testPremiumPackagesCurrencyEN() {
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
        // Verify Premium package currency in English
        subscriptionPlans.checkPremiumCurrencyPriceEN(actuaPremiumPackageCurrencyEN);
    }
    // Test to verify Premium package currency in Arabic for Bahrain
    @Test
    public void testPremiumPackagesCurrencyAR() {
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscriptionPlans.changeToArabic();
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
        // Verify Premium package currency in English
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