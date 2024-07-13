package Tests.SubscriptionPlansSA.LitePlanSA;

import Pages.SubscriptionPlans;
import Resources.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LitePackagesCurrencySA {
    private WebDriver driver;
    private SubscriptionPlans subscriptionPlans;
    private String actualLitePackageCurrencyEN;
    private String actualLitePackageCurrencyAR;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects
        subscriptionPlans = new SubscriptionPlans(driver);
        //
        actualLitePackageCurrencyEN = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_SA_EN;
        actualLitePackageCurrencyAR = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_SA_AR;
    }
    //
    @Test
    public void testLitePackagesCurrencyEN() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Verify Lite Packages Currency
        subscriptionPlans.checkLiteCurrencyPriceEN(actualLitePackageCurrencyEN);
    }
    //
    @Test
    public void testLitePackagesCurrencyAR() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscriptionPlans.changeToArabic();
        // Verify Lite Packages Currency
        subscriptionPlans.checkLiteCurrencyPriceAR(actualLitePackageCurrencyAR);
    }
    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
