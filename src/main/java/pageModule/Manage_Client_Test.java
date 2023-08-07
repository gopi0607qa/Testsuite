package pageModule;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import util.Currentdate;
import util.Email_custom;
import webElement.Client_xpath;

public class Manage_Client_Test extends Testbase {
	public static BasicFunction fun = new BasicFunction();

	// Add client test method
	public void Add_Client(ExtentTest test, WebDriver driver, String Firstname, String Lastname, String Email,
			String Phone, String Address1, String Address2, String City, String Zipcode, String browser,
			String testname) throws IOException, AWTException {

		// Web Element class called
		Client_xpath client_xpath = new Client_xpath(driver);

		// Test script sequence to check Add Professional
		try {
			fun.Click(driver, client_xpath.manage_client_menu);
			test.log(Status.INFO, "Manage Professionals menu is clicked",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			fun.Click(driver, client_xpath.add_client_button);
			test.log(Status.INFO, "Add Professional button is clicked",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.explicit_Wait_Click(driver, client_xpath.select_shop);
			fun.Click(driver, client_xpath.select_shop);
			fun.Sendkeys(driver, client_xpath.shop_input, "Naturals");
			fun.Click(driver, client_xpath.shop_list.get(0));

//			Select select_shop = new Select(client_xpath.select_shop);
//			fun.explicit_Wait(driver, client_xpath.select_shop);
//			select_shop.selectByIndex(2);
//			test.log(Status.INFO, "Shop is selected",
//					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			Select select_profession = new Select(client_xpath.select_profession);
			fun.explicit_Wait(driver, client_xpath.select_profession);
			select_profession.selectByIndex(1);
			test.log(Status.INFO, "Profession is selected",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Sendkeys(driver, client_xpath.client_first_name, Firstname);
			test.log(Status.INFO, "First name is entered.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Sendkeys(driver, client_xpath.client_last_name, Lastname);
			test.log(Status.INFO, "Last name is entered.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Sendkeys(driver, client_xpath.client_email, Email);
			test.log(Status.INFO, "Email is entered.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Sendkeys(driver, client_xpath.client_phone, Phone);
			test.log(Status.INFO, "Phone# is entered.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Sendkeys(driver, client_xpath.client_address_1, Address1);
			test.log(Status.INFO, "Address1 is entered.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Sendkeys(driver, client_xpath.client_address_2, Address2);
			test.log(Status.INFO, "Address2 is entered.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Sendkeys(driver, client_xpath.client_city, City);
			test.log(Status.INFO, "City is entered.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			Select select_state = new Select(client_xpath.select_state);
			fun.explicit_Wait(driver, client_xpath.select_state);
			select_state.selectByIndex(2);
			test.log(Status.INFO, "State is selected",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Sendkeys(driver, client_xpath.client_zipcode, Zipcode);
			test.log(Status.INFO, "Zipcode is entered.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Click(driver, client_xpath.client_form_submit);
			test.log(Status.INFO, "Add button is clicked.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.explicit_Wait(driver, client_xpath.success_popup);
			if (client_xpath.success_popup.getText().equalsIgnoreCase("Professional added successfully!")) {
				String e_messagepass = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On "
						+ Currentdate.Systemdate() + " Client added given below:" + '\n' + "First name is " + Firstname
						+ '\n' + "Last name is " + Lastname + '\n' + "Email is " + Email + "Phone is " + Phone + '\n'
						+ "Address 1 is " + Address1 + '\n' + "Address 2 is " + Address2 + '\n' + "City is " + City
						+ '\n' + "Zipcode is " + Zipcode + '\n';
				String teststatus = "Add client test passed.";
				Email_custom.emailSendpass(testname, teststatus, e_messagepass);
				test.log(Status.PASS, client_xpath.success_popup.getText() + '\n' + e_messagepass,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);

				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			} else {

				String e_messagefail = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On "
						+ Currentdate.Systemdate() + " Client added given below:" + '\n' + "First name is" + Firstname
						+ '\n' + "Last name is " + Lastname + "Email is " + Email + "Phone is " + Phone + '\n'
						+ "Address 1 is " + Address1 + '\n' + "Address 2 is " + Address2 + '\n' + "City is " + City
						+ '\n' + "Zipcode is " + Zipcode + '\n';
				String teststatus = "Add client test failed.";
				test.log(Status.FAIL,
						"Message should be 'Professional added successfully!'	 but it displays - "
								+ client_xpath.success_popup.getText() + '\n' + e_messagefail,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				Email_custom.emailSendfail(testname, teststatus, e_messagefail);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String e_messagefail = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On "
					+ Currentdate.Systemdate() + " Client added given below: " + '\n' + "First name is " + Firstname
					+ '\n' + "Last name is " + Lastname + "Email is " + Email + "Phone is " + Phone + '\n'
					+ "Address 1 is " + Address1 + '\n' + "Address 2 is " + Address2 + '\n' + "City is " + City + '\n'
					+ "Zipcode is " + Zipcode + '\n';
			String teststatus = "Add client test failed, with Exception:" + '\n' + '\n'
					+ ExceptionUtils.getStackTrace(e);
			Email_custom.emailSendfail(testname, teststatus, e_messagefail);
			test.log(Status.FAIL, e_messagefail + '\n' + teststatus,
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
		}
	}

	// Suspend client test script
	public void Suspend_client(ExtentTest test, WebDriver driver, String browser, String testname)
			throws IOException, AWTException {

		Client_xpath client_xpath = new Client_xpath(driver);

		try {

			fun.Click(driver, client_xpath.suspend_first_button);
			test.log(Status.INFO, "Suspend icon is clicked.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			fun.Click(driver, client_xpath.confirm_alert_button);
			test.log(Status.INFO, "Confirm delete it button is clicked",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			fun.explicit_Wait(driver, client_xpath.success_popup);
			if (client_xpath.success_popup.getText().equalsIgnoreCase("Professional suspended successfully!")) {
				test.log(Status.PASS, client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				String e_messagepass = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On "
						+ Currentdate.Systemdate() + " Suspend professional test is PASSED..!" + '\n';
				String teststatus = "Suspend professional test passed.";
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				Email_custom.emailSendpass(testname, teststatus, e_messagepass);

			} else {
				test.log(Status.FAIL,
						"Message should be 'Professional suspended successfully!' but it displays - "
								+ client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				String e_messagefail = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On "
						+ Currentdate.Systemdate() + " Suspend client test is failed." + " Message displayed is "
						+ client_xpath.success_popup.getText() + '\n';
				String teststatus = "Suspend client test failed.";
				Email_custom.emailSendpass(testname, teststatus, e_messagefail);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.INFO, e.toString(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			String e_messagefail = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On "
					+ Currentdate.Systemdate() + " Suspend client test is failed." + '\n';
			String teststatus = '\n' + '\n' + browser + '\n' + '\n' + "Suspend client test failed with Exception."
					+ '\n' + ExceptionUtils.getStackTrace(e);
			Email_custom.emailSendpass(testname, teststatus, e_messagefail);
		}

	}

	// Unsuspend client test script
	public void Unsuspend_client(ExtentTest test, WebDriver driver, String browser, String testname)
			throws IOException, AWTException {

		Client_xpath client_xpath = new Client_xpath(driver);

		try {
			fun.Click(driver, client_xpath.suspend_first_button);
			fun.Click(driver, client_xpath.confirm_alert_button);
			fun.explicit_Wait(driver, client_xpath.success_popup);
			if (client_xpath.success_popup.getText().equalsIgnoreCase("Professional unsuspended successfully!")) {
				test.log(Status.PASS, client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				String e_messagepass = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On "
						+ Currentdate.Systemdate() + " Unuspend professional test is PASSED..!" + '\n';
				String teststatus = "Unsuspend professional test passed.";
				Email_custom.emailSendpass(testname, teststatus, e_messagepass);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			} else {
				test.log(Status.FAIL,
						"Message should be 'Professional unsuspended successfully!'	 but it displays - "
								+ client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				String e_messagefail = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On "
						+ Currentdate.Systemdate() + " Unsuspend professional test is failed."
						+ " Message displayed is " + client_xpath.success_popup.getText() + '\n';
				String teststatus = "Unsuspend professional test failed.";
				Email_custom.emailSendpass(testname, teststatus, e_messagefail);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String e_messagefail = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On "
					+ Currentdate.Systemdate() + " Unsuspend professional test is failed." + '\n';
			String teststatus = "Unsuspend professional test failed with Exception." + '\n'
					+ ExceptionUtils.getStackTrace(e);
			Email_custom.emailSendpass(testname, teststatus, e_messagefail);
			test.log(Status.INFO, e.toString(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
		}

	}

	// Delete Professional test script
	public void Delete_client(ExtentTest test, WebDriver driver, String browser, String testname)
			throws IOException, AWTException {

		Client_xpath client_xpath = new Client_xpath(driver);

		try {

			fun.Click(driver, client_xpath.delete_first_client);
			fun.Click(driver, client_xpath.confirm_alert_button);
			fun.explicit_Wait(driver, client_xpath.success_popup);
			if (client_xpath.success_popup.getText().equalsIgnoreCase("Professional deleted successfully!")) {
				test.log(Status.PASS, client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				String e_messagepass = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On "
						+ Currentdate.Systemdate() + " Delete professional test is PASSED..!" + '\n';
				String teststatus = "Delete professional test passed.";
				Email_custom.emailSendpass(testname, teststatus, e_messagepass);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			} else {
				test.log(Status.FAIL,
						"Message should be 'Professional deleted successfully!'	 but it displays - "
								+ client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				String e_messagefail = "On " + Currentdate.Systemdate() + " Delete professional test is failed."
						+ " Message displayed is " + client_xpath.success_popup.getText() + '\n' + browser;
				String teststatus = "Delete Professional test failed.";
				Email_custom.emailSendpass(testname, teststatus, e_messagefail);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String e_messagefail = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On "
					+ Currentdate.Systemdate() + " Delete professional test is failed." + '\n';
			String teststatus = "Delete professional test failed with Exception." + '\n'
					+ ExceptionUtils.getStackTrace(e);
			Email_custom.emailSendpass(testname, teststatus, e_messagefail);
			test.log(Status.INFO, e.toString(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
		}

	}

}
