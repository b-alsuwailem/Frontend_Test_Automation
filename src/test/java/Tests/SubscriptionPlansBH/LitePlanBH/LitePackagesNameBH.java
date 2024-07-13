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

public class LitePackagesNameBH {
    private WebDriver driver;
    private SubscriptionPlans subscriptionPlans;
    private String actualLitePackageNameEN;
    private String actualLitePackageNameAR;
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
        actualLitePackageNameEN = Constants.SubscribePageFields.PackagesName.LITE_PACKAGE_ACTUAL_NAME_EN;
        actualLitePackageNameAR = Constants.SubscribePageFields.PackagesName.LITE_PACKAGE_ACTUAL_NAME_AR;
        // Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }
    //
    @Test
    public void testLitePackagesNameEN() {
        test = extent.createTest("Verify Lite Package name in English for Bahrain");
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
        // Verify Lite Packages Name
        subscriptionPlans.checkLitePackageNameEN(actualLitePackageNameEN);
    }
    //
    @Test
    public void testLitePackagesNameAR() {
        test = extent.createTest("Verify Lite Package name in Arabic for Bahrain");
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscriptionPlans.changeToArabic();
        // Change country to Bahrain
        subscriptionPlans.changeCountryToBahrain();
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
        extent.flush();
    }
}


