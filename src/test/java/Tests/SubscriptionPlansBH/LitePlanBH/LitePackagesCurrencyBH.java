package Tests.SubscriptionPlansBH.LitePlanBH;

import Pages.SubscriptionPlans;
import Resources.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// Test class for verifying Lite package currency in Bahrain for both English and Arabic
public class LitePackagesCurrencyBH {
    private WebDriver driver;
    private SubscriptionPlans subscriptionPlans;
    private String actualLitePackageCurrencyEN;
    private String actualLitePackageCurrencyAR;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    // Method to setup WebDriver and initialize page objects
    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects "SubscriptionPlans'
        subscriptionPlans = new SubscriptionPlans(driver);
        // Set expected currencies for Lite package in English and Arabic
        actualLitePackageCurrencyEN = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_BH_EN;
        actualLitePackageCurrencyAR = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_BH_AR;
        // Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }
    // Test to verify Lite package currency in English for Bahrain
    @Test
    public void testLitePackagesCurrencyEN() {
        test = extent.createTest("Verify Lite Package currency in English for Bahrain");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
        // Verify Lite package currency in English
        subscriptionPlans.checkLiteCurrencyPriceEN(actualLitePackageCurrencyEN);
    }
    // / Test to verify Lite package currency in Arabic for Bahrain
    @Test
    public void testLitePackagesCurrencyAR() {
        test = extent.createTest("Verify Lite Package currency in Arabic for Bahrain");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscriptionPlans.changeToArabic();
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
        // Verify Lite package currency in English
        subscriptionPlans.checkLiteCurrencyPriceAR(actualLitePackageCurrencyAR);
    }
    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }
}
