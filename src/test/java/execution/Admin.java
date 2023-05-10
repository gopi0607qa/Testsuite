package execution;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
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
import pageModule.Login_Test;
import pageModule.Manage_Client_Test;
import pageModule.Manage_Profession_Test;
import util.ReadExcel;

public class Admin extends Testbase {

	public Login_Test login = new Login_Test();
	public Manage_Client_Test manage_client = new Manage_Client_Test();
	public Manage_Profession_Test manage_profession = new Manage_Profession_Test();
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
		browserinitialization(browsername, test);
	}

	@DataProvider(name = "LoginValidData")
	public Object[][] readExcel() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(
				System.getProperty("user.dir") + "/src/test/resources/excel/Unext_Admin_credentials.xlsx",
				"LoginValidData");
	}

	@DataProvider(name = "LoginInvalidData")
	public Object[][] readExcel1() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(
				System.getProperty("user.dir") + "/src/test/resources/excel/Unext_Admin_credentials.xlsx",
				"LoginInvalidData");

	}

	@DataProvider(name = "AddClient")
	public Object[][] readExcel2() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(
				System.getProperty("user.dir") + "/src/test/resources/excel/Unext_Admin_credentials.xlsx", "AddClient");

	}

	@Test(dataProvider = "LoginValidData", enabled = true, priority = 1, threadPoolSize = 9)
	@Parameters({ "browsername" })
	public void Logintest(String UserName, String Password) throws InterruptedException, IOException, AWTException {
		System.out.println("Login Test case");
		test = report.createTest("Login Test Case");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		login.Login_Page(test, driver, UserName, Password);
		login.Login_valid(test, driver, UserName, Password);

	}

	@Test(dataProvider = "LoginInvalidData", enabled = false, priority = 2, threadPoolSize = 9)
	@Parameters({ "browsername" })
	public void Logininvalidtest(String UserName, String Password)
			throws InterruptedException, IOException, AWTException {
		System.out.println(" Invalid Login Test case");
		test = report.createTest("Invalid Login Test Case");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		login.Login_Page(test, driver, UserName, Password);
		login.Login_invalid(test, driver, UserName, Password);
	}

	@Test(dataProvider = "AddClient", enabled = false, priority = 3, threadPoolSize = 9)
	@Parameters({ "browsername" })
	public void Add_Client_test(String UserName, String Password, String Firstname, String Lastname, String Email,
			String Phone, String Address1, String Address2, String City, String Zipcode)
			throws InterruptedException, IOException, AWTException {
		System.out.println("Manage Client Test cases");
		test = report.createTest("Manage client Test Case");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		login.Login_Page(test, driver, UserName, Password);
		manage_client.Add_Client(test, driver, Firstname, Lastname, Email, Phone, Address1, Address2, City, Zipcode);
		manage_client.Suspend_client(test, driver);
		manage_client.Unsuspend_client(test, driver);
		manage_client.Delete_client(test, driver);
	}

	@Test(dataProvider = "LoginValidData", enabled = false, priority = 4, threadPoolSize = 9)
	public void Manage_Profession_test(String UserName, String Password)
			throws InterruptedException, IOException, AWTException {
		System.out.println("Manage Profession test");
		test = report.createTest("Managae Profession Test cases");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		login.Login_Page(test, driver, UserName, Password);
		manage_profession.Add_Profession(test, driver);
		manage_profession.Edit_Profession(test, driver);
		manage_profession.Delete_Profession(test, driver);

	}

	@AfterMethod
	public void aftermethod() {
		DriverFactory.getInstance().Close();
		System.out.println("This is after method");

	}

	@AfterClass
	public void afterclass() {
		System.out.println("This is after class");
		report.flush();

	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("This is after suite");

	}

}