package Tests.SubscriptionPlansKW.LitePlanKW;

import Pages.SubscriptionPlans;
import Resources.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LitePackagesNameKW {
    private WebDriver driver;
    private SubscriptionPlans subscriptionPlans;
    private String litePackageNameEN;
    private String litePackageNameAR;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects
        subscriptionPlans = new SubscriptionPlans(driver);
        //
        litePackageNameEN = Constants.SubscribePageFields.PackagesName.LITE_PACKAGE_ACTUAL_NAME_EN;
        litePackageNameAR = Constants.SubscribePageFields.PackagesName.LITE_PACKAGE_ACTUAL_NAME_AR;
    }
    //
    @Test
    public void testLitePackagesCurrencyEN() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change country to Kuwait
        subscriptionPlans.changeCountryToKuwait();
        // Verify Lite Packages Currency
        subscriptionPlans.checkLitePackageNameEN(litePackageNameEN);
    }
    //
    @Test
    public void testLitePackagesCurrencyAR() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscriptionPlans.changeToArabic();
        // Change country to Kuwait
        subscriptionPlans.changeCountryToKuwait();
        // Verify Lite Packages Currency
        subscriptionPlans.checkLitePackageNameAR(litePackageNameAR);
    }
    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
