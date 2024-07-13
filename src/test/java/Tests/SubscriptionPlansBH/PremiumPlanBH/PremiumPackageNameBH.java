package Tests.SubscriptionPlansBH.PremiumPlanBH;

import Pages.SubscriptionPlans;
import Resources.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PremiumPackageNameBH {
    private WebDriver driver;
    private SubscriptionPlans subscriptionPlans;
    private String actuaPremiumPackageNameEN;
    private String actuaPremiumPackageNameAR;
    //
    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects
        subscriptionPlans = new SubscriptionPlans(driver);
        //
        actuaPremiumPackageNameEN = Constants.SubscribePageFields.PackagesName.PREMIUM_PACKAGE_ACTUAL_NAME_EN;
        actuaPremiumPackageNameAR = Constants.SubscribePageFields.PackagesName.PREMIUM_PACKAGE_ACTUAL_NAME_AR;
    }
    //
    @Test
    public void testPremiumPackagesNameEN() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
        // Verify Lite Packages Name
        subscriptionPlans.checkPremiumPackageNameEN(actuaPremiumPackageNameEN);
    }
    //
    @Test
    public void testPremiumPackagesNameAR() {
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscriptionPlans.changeToArabic();
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
        // Verify Lite Packages Name
        subscriptionPlans.checkPremiumPackageNameAR(actuaPremiumPackageNameAR);
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
