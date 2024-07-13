package Tests.SubscriptionPlansSA.LitePlanSA;
import Pages.SubscriptionPlans;
import Resources.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LitePackagesNameSA {
    private WebDriver driver;
    private SubscriptionPlans subscriptionPlans;
    private String actualLitePackageNameEN;
    private String actualLitePackageNameAR;
    //
    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects
        subscriptionPlans = new SubscriptionPlans(driver);
        //
        actualLitePackageNameEN = Constants.SubscribePageFields.PackagesName.LITE_PACKAGE_ACTUAL_NAME_EN;
        actualLitePackageNameAR = Constants.SubscribePageFields.PackagesName.LITE_PACKAGE_ACTUAL_NAME_AR;
    }
    //
    @Test
    public void testLitePackagesNameEN() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Verify Lite Packages Name
        subscriptionPlans.checkLitePackageNameEN(actualLitePackageNameEN);
    }
    //
    @Test
    public void testLitePackagesNameAR() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscriptionPlans.changeToArabic();
        // Verify Lite Packages Name
        subscriptionPlans.checkLitePackageNameAR(actualLitePackageNameAR);
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

