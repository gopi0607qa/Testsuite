package pageModule;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import webElement.Login_xpath;

public class Login_Test extends Testbase {
	public static BasicFunction fun = new BasicFunction();

	public void Login_Page(ExtentTest test, WebDriver driver, String UserName, String Password)
			throws InterruptedException, IOException, AWTException {
		Login_xpath login_xp = new Login_xpath(driver);

		fun.Sendkeys(driver, login_xp.email_field, UserName);
		fun.Sendkeys(driver, login_xp.password_field, Password);
		System.out.println();
		fun.Click(driver, login_xp.Login_button);
		Thread.sleep(4000);
		test.log(Status.INFO, "Login Button CLicked",
				MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
		System.out.println("Login button clicked");

	}

	public void Login_valid(ExtentTest test, WebDriver driver, String UserName, String Password)
			throws InterruptedException, IOException, AWTException {
		if (driver.getCurrentUrl().equalsIgnoreCase("https://dev.datanetiix.com/unext/admin/dashboard")) {
			System.out.println("Admin page opened, the URL is :" + driver.getCurrentUrl());

			test.log(Status.PASS, "Valid Login Test passed, Opened URL is " + driver.getCurrentUrl(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
		} else {
			System.out.println("Login valid failed");
			test.log(Status.FAIL, "Valid login Test Failed. The opened URL is : " + driver.getCurrentUrl(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
		}

	}

	public void Login_invalid(ExtentTest test, WebDriver driver, String UserName, String Password)
			throws InterruptedException, IOException, AWTException {
		Login_xpath login_xp = new Login_xpath(driver);

		try {

			if (login_xp.error_mail.isDisplayed() == true && login_xp.error_password.isDisplayed() == false) {

				fun.Scroll(driver, login_xp.error_mail);
				String email_error = login_xp.error_mail.getText();
				test.log(Status.PASS,
						"Validation message displayed in the email field: " + email_error + "  Test data - Username: "
								+ UserName + " and Password: " + Password,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				System.out.println(UserName + "  " + Password + "  " + email_error);

			} else if (login_xp.error_password.isDisplayed() == true && login_xp.error_mail.isDisplayed() == false) {

				fun.Scroll(driver, login_xp.error_password);
				String password_error = login_xp.error_password.getText();
				test.log(Status.PASS,
						"Validation message displayed in the password field: " + password_error
								+ "  Test data - Username: " + UserName + " and Password: " + Password,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				System.out.println(UserName + "  " + Password + "  " + password_error);

			} else if (login_xp.error_password.isDisplayed() == true && login_xp.error_mail.isDisplayed() == true) {

				fun.Scroll(driver, login_xp.error_password);
				String password_error = login_xp.error_password.getText();
				String email_error = login_xp.error_mail.getText();
				test.log(Status.PASS,
						"Validation message displayed in the email field : " + email_error
								+ "Validation message displayed in the Password field : " + password_error
								+ "  Test data - Username: " + UserName + " and Password: " + Password,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				System.out.println(UserName + "  " + Password + "  " + email_error + password_error);

			} else if (driver.getCurrentUrl()
					.equalsIgnoreCase("https://dev.datanetiix.com/unext/admin/dashboard") == true) {

				test.log(Status.FAIL,
						"Invalid login test failed. " + "Admin Dashboard has been opened for invalid login"
								+ "Test data - Username: " + UserName + "   Password: " + Password,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				System.out.println(UserName + "  " + Password + "  ");

			} else if (login_xp.alert_msg.isDisplayed() == true) {
				fun.Scroll(driver, login_xp.alert_msg);
				String alert_text = login_xp.alert_msg.getText();
				test.log(Status.PASS,
						"Validation message displayed : " + alert_text + "  Test data - Username: " + UserName
								+ " and Password: " + Password,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				System.out.println(UserName + "  " + Password + alert_text);
			}
		} catch (Exception e) {
			String stacktrace = ExceptionUtils.getStackTrace(e);
			test.log(Status.FAIL, " Exception occured. Throws details : " + stacktrace,
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			e.printStackTrace();

		}

	}
}
