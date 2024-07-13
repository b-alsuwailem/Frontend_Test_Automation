// Import necessary packages and libraries
package Tests.SubscriptionPlansSA.ClassicPlanSA;

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

// Test class for verifying Classic package name in KSA for both English and Arabic
public class ClassicPackagesNameSA {
    private WebDriver driver;
    private SubscriptionPlans subscriptionPlans;
    private String classicPackageNameEN;
    private String classicPackageNameAR;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    // Method to setup WebDriver and initialize page objects
    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects "SubscriptionPlans"
        subscriptionPlans = new SubscriptionPlans(driver);
        // Set expected names for Classic package in English and Arabic
        classicPackageNameEN = Constants.SubscribePageFields.PackagesName.CLASSIC_PACKAGE_ACTUAL_NAME_EN;
        classicPackageNameAR = Constants.SubscribePageFields.PackagesName.CLASSIC_PACKAGE_ACTUAL_NAME_AR;
        // Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    // Test to verify Classic package name in English for KSA
    @Test
    public void testClassicPackagesNameEN() {
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Verify Classic package name in English
        subscriptionPlans.checkClassicPackageNameEN(classicPackageNameEN);
    }

    // Test to verify Classic package name in Arabic for KSA
    @Test
    public void testClassicPackagesNameAR() {
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscriptionPlans.changeToArabic();
        // Verify Classic package name in English
        subscriptionPlans.checkClassicPackageNameAR(classicPackageNameAR);
    }

    // Method to close the browser after all tests are executed
    @AfterClass
    public void cleanUp() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
        // Flush ExtentReports to write test information to the HTML report
        extent.flush();
    }
}