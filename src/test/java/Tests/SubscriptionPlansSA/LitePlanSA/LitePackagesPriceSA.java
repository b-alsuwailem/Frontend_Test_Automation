package Tests.SubscriptionPlansSA.LitePlanSA;
import Pages.SubscriptionPlans;
import Resources.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LitePackagesPriceSA {
    private WebDriver driver;
    private SubscriptionPlans subscriptionPlans;
    private String actualLitePackagePrice;
    //
    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects
        subscriptionPlans = new SubscriptionPlans(driver);
        //
        actualLitePackagePrice = Constants.SubscribePageFields.PackagesPrice.LITE_PACKAGE_ACTUAL_PRICE_SA;
    }
    //
    @Test
    public void testLitePackagesPriceEN() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Verify Lite Packages Price
        subscriptionPlans.checkLitePackagePriceEN(actualLitePackagePrice);
    }
    @Test
    public void testLitePackagesPriceAR() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscriptionPlans.changeToArabic();
        // Verify Lite Packages Price
        subscriptionPlans.checkLitePackagePriceAR(actualLitePackagePrice);
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
