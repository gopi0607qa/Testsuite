package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Testbase {

	public static BasicFunction fun = new BasicFunction();
	static BrowserFactory bf = new BrowserFactory();

	public static void browserinitialization(String browsername, ExtentTest test)
			throws IOException, InterruptedException {

		DriverFactory.getInstance().setDriver(bf.createbrowserInstance(browsername));
		WebDriver driver = DriverFactory.getInstance().getDriver();

		driver.manage().window().maximize();
		String url = "https://dev.datanetiix.com/unext/adminlogin";
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Navigated to URL : " + url);

//		String Title = driver.getTitle();
		if (driver.getCurrentUrl().contentEquals(url)) {
			System.out.println("PASS: Admin Login Page opened Successfully");
			test.log(Status.PASS, "Admin Login Page opened Successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

		} else {
			System.out.println("FAIL: Admin Login Page is failed to open.");
			test.log(Status.FAIL, "Page is not navigated " + "Expected URL " + url + " Actual Title is :  "
					+ driver.getCurrentUrl()
					+ MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

		}

	}

}
