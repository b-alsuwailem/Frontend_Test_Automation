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

public class LitePackagesPriceBH {
    private WebDriver driver;
    private SubscriptionPlans subscriptionPlans;
    private String actualLitePackagePrice;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();
    //
    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects
        subscriptionPlans = new SubscriptionPlans(driver);
        //
        actualLitePackagePrice = Constants.SubscribePageFields.PackagesPrice.LITE_PACKAGE_ACTUAL_PRICE_BH;
        // Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }
    //
    @Test
    public void testLitePackagesPriceEN() {
        test = extent.createTest("Verify Lite Package price in English for Bahrain");
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
        // Verify Lite Packages Price
        subscriptionPlans.checkLitePackagePriceEN(actualLitePackagePrice);
    }
    @Test
    public void testLitePackagesPriceAR() {
        test = extent.createTest("Verify Lite Package price in Arabic for Bahrain");
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
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
        extent.flush();
    }
}
