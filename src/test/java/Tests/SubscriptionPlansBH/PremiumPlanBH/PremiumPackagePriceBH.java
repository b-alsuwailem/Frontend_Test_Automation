package Tests.SubscriptionPlansBH.PremiumPlanBH;

import Pages.SubscriptionPlans;
import Resources.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PremiumPackagePriceBH {
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
        actuaPremiumPackagePrice = Constants.SubscribePageFields.PackagesPrice.PREMIUM_PACKAGE_ACTUAL_PRICE_BH;
    }
    //
    @Test
    public void testPremiumPackagesPriceEN() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
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
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
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