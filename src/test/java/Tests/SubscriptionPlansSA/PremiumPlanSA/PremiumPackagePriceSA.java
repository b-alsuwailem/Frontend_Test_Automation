package Tests.SubscriptionPlansSA.PremiumPlanSA;

import Pages.SubscriptionPlans;
import Resources.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PremiumPackagePriceSA {
    private WebDriver driver;
    private SubscriptionPlans subscriptionPlans;
    private String actuaPremiumPackagePrice;
    //
    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects
        subscriptionPlans = new SubscriptionPlans(driver);
        //
        actuaPremiumPackagePrice = Constants.SubscribePageFields.PackagesPrice.PREMIUM_PACKAGE_ACTUAL_PRICE_SA;
    }
    //
    @Test
    public void testPremiumPackagesPriceEN() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Verify Lite Packages Price
        subscriptionPlans.checkPremiumPackagePriceEN(actuaPremiumPackagePrice);
    }
    //
    @Test
    public void testPremiumPackagesPriceAR() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscriptionPlans.changeToArabic();
        // Verify Lite Packages Price
        subscriptionPlans.checkPremiumPackagePriceAR(actuaPremiumPackagePrice);
    }
    //
    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}