package pageModule;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import util.Currentdate;
import util.Email_custom;
import webElement.Login_xpath;

public class Pro_Login_Test {

	public static BasicFunction fun = new BasicFunction();

	public void Login_Page(ExtentTest test, WebDriver driver, String UserName, String Password)
			throws InterruptedException, IOException, AWTException {
		Login_xpath login_xp = new Login_xpath(driver);

		fun.Sendkeys(driver, login_xp.email_field, UserName);
		fun.Sendkeys(driver, login_xp.password_field, Password);
		System.out.println();
		fun.Click(driver, login_xp.Login_button);
//		Thread.sleep(4000);
		test.log(Status.INFO, "Login Button CLicked",
				MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
		System.out.println("Login button clicked");

	}

	public void Login_valid(ExtentTest test, WebDriver driver, String UserName, String Password, String testname,
			String browser) throws InterruptedException, IOException, AWTException {

		try {

			String e_messagepass = "On " + Currentdate.Systemdate() + " Valid Login Test passed, Opened URL is "
					+ driver.getCurrentUrl() + '\n' + browser;
			String teststatus = "Test Passed";
			if (driver.getCurrentUrl().equalsIgnoreCase("https://dev.datanetiix.com/unext/stylist/dashboard")) {
				System.out.println("Stylist dashboard page opened, the URL is :" + driver.getCurrentUrl() + '\n' + '\n'
						+ "Tested browser: " + '\n' + browser);

				test.log(Status.PASS, e_messagepass,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

				Email_custom.emailSendpass(testname, teststatus, e_messagepass);
			}
		} catch (Exception e) {
			System.out.println("Login valid failed");
			String e_messagefail = "On " + Currentdate.Systemdate() + "Valid login test failed." + '\n'
					+ "Tested browser: " + '\n' + browser + '\n' + '\n' + "Exception message: " + '\n'
					+ ExceptionUtils.getStackTrace(e);
			String teststatus = "Test failed";
			test.log(Status.FAIL,
					"On " + Currentdate.Systemdate() + " Valid Login Test Failed. The opened URL is : "
							+ driver.getCurrentUrl() + "Exception:  " + e_messagefail,
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			Email_custom.emailSendfail(testname, teststatus, e_messagefail);
		}

	}

	public void Login_invalid(ExtentTest test, WebDriver driver, String UserName, String Password, String browser,
			String testname) throws InterruptedException, IOException, AWTException {
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
