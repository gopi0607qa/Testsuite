package execution;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.DriverFactory;
import base.Testbase;
import pageModule.Pro_Login_Test;
import pageModule.Setting_Photo_upload;
import util.Email_custom;
import util.ReadExcel;

public class Professional extends Testbase {

	public Pro_Login_Test pro_login = new Pro_Login_Test();
	public Setting_Photo_upload set_photo_upload = new Setting_Photo_upload();
	public static ExtentTest test;
	public static ExtentReports report;

	@BeforeSuite
	public void beforesuite() {
		System.out.println("This is before suite");
	}

	@BeforeClass
	public void beforeclass() throws IOException {
		System.out.println("This is before class");

		report = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/src/test/resources/output/ExtentReport.html");

		report.setSystemInfo("Tested By", "GopiNath");
		report.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName().toString());
		report.setSystemInfo("Operating System", System.getProperty("os.name").toString());
		report.setSystemInfo("Environment", "Development");

		final File CONF = new File(System.getProperty("user.dir") + "/src/test/resources/config/extent-config.xml");
		spark.loadXMLConfig(CONF);

		report.attachReporter(spark);

	}

	@BeforeMethod
	@Parameters({ "browsername" })
	public void beforemethod(String browsername) throws IOException, InterruptedException {
		System.out.println("Before Method");
		test = report.createTest(browsername + "Browser Intialization");
		browserinitializationpro(browsername, test);
	}

	@DataProvider(name = "ProLoginValidData")
	public Object[][] readExcel() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(
				System.getProperty("user.dir") + "/src/test/resources/excel/Unext_Admin_credentials.xlsx",
				"ProValidLogin");
	}

	@DataProvider(name = "ProLoginInvalidData")
	public Object[][] readExcel1() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(
				System.getProperty("user.dir") + "/src/test/resources/excel/Unext_Admin_credentials.xlsx",
				"ProValidLogin");

	}

	@Test(dataProvider = "ProLoginValidData", enabled = false, priority = 1, threadPoolSize = 9)
	@Parameters({ "browsername" })
	public void Logintest(String UserName, String Password) throws InterruptedException, IOException, AWTException {
		String testname = "Professional Login Test case";
		System.out.println(testname);
		test = report.createTest(testname);
		WebDriver driver = DriverFactory.getInstance().getDriver();
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browser = "Browser name: " + caps.getBrowserName() + '\n' + "Browser version: "
				+ caps.getBrowserVersion();
		pro_login.Login_Page(test, driver, UserName, Password);
		pro_login.Login_valid(test, driver, UserName, Password, testname, browser);
		System.out.println("Completed the test: " + testname);

	}

	@Test(dataProvider = "ProLoginInvalidData", enabled = false, priority = 2, threadPoolSize = 9)
	@Parameters({ "browsername" })
	public void Logininvalidtest(String UserName, String Password)
			throws InterruptedException, IOException, AWTException {

		String testname = " Professional Invalid Login Test case";
		System.out.println(testname);
		test = report.createTest(testname);
		WebDriver driver = DriverFactory.getInstance().getDriver();
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browser = "Browser name: " + caps.getBrowserName() + '\n' + "Browser version: "
				+ caps.getBrowserVersion();
		pro_login.Login_Page(test, driver, UserName, Password);
		pro_login.Login_invalid(test, driver, UserName, browser, testname, Password);
		System.out.println("Completed the test: " + testname);
	}

	@Test(dataProvider = "ProLoginValidData", enabled = true, priority = 3, threadPoolSize = 9)
	@Parameters({ "browsername" })
	public void Profileimageuploadtest(String UserName, String Password)
			throws InterruptedException, IOException, AWTException {

		String testname = "Profile photo upload test";
		System.out.println(testname);
		test = report.createTest(testname);
		WebDriver driver = DriverFactory.getInstance().getDriver();
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browser = "Browser name: " + caps.getBrowserName() + '\n' + "Browser version: "
				+ caps.getBrowserVersion();
		pro_login.Login_Page(test, driver, UserName, Password);
		set_photo_upload.Profile_upload(test, driver, browser, testname);
		System.out.println("Completed the test: " + testname);

	}

	@Test(dataProvider = "ProLoginInvalidData", enabled = true, priority = 4, threadPoolSize = 9)
	@Parameters({ "browsername" })
	public void Logoimageuploadtest(String UserName, String Password)
			throws InterruptedException, IOException, AWTException {

		String testname = "Logo photo upload test";
		System.out.println(testname);
		test = report.createTest(testname);
		WebDriver driver = DriverFactory.getInstance().getDriver();
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browser = "Browser name: " + caps.getBrowserName() + '\n' + "Browser version: "
				+ caps.getBrowserVersion();
		pro_login.Login_Page(test, driver, UserName, Password);
		set_photo_upload.Logo_upload(test, driver, browser, testname);
		System.out.println("Completed the test: " + testname);

	}

	@AfterMethod
	public void aftermethod() {
		DriverFactory.getInstance().Close();
		System.out.println("This is after method");

	}

	@AfterClass
	public void afterclass() {

		System.out.println("This is after class");

	}

	@AfterSuite

	public void aftersuite() {

		report.flush();
		Email_custom.emailSend();
		System.out.println("This is after suite");
	}

}
