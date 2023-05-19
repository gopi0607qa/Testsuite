package pageModule;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import webElement.Client_xpath;

public class Manage_Client_Test extends Testbase {
	public static BasicFunction fun = new BasicFunction();

	// Add client test method
	public void Add_Client(ExtentTest test, WebDriver driver, String Firstname, String Lastname, String Email,
			String Phone, String Address1, String Address2, String City, String Zipcode)
			throws IOException, AWTException {

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

			Select select_shop = new Select(client_xpath.select_shop);
			fun.explicit_Wait(driver, client_xpath.select_shop);
			select_shop.selectByIndex(2);
			test.log(Status.INFO, "Shop is selected",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

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
				test.log(Status.PASS, client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			} else {
				test.log(Status.FAIL,
						"Message should be 'Professional added successfully!'	 but it displays - "
								+ client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.FAIL, e.toString(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
		}
	}

	// Suspend client test script
	public void Suspend_client(ExtentTest test, WebDriver driver) throws IOException, AWTException {

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
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			} else {
				test.log(Status.FAIL,
						"Message should be 'Professional suspended successfully!' but it displays - "
								+ client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.INFO, e.toString(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
		}

	}

	// Unsuspend client test script
	public void Unsuspend_client(ExtentTest test, WebDriver driver) throws IOException, AWTException {

		Client_xpath client_xpath = new Client_xpath(driver);

		try {
			fun.Click(driver, client_xpath.suspend_first_button);
			fun.Click(driver, client_xpath.confirm_alert_button);
			fun.explicit_Wait(driver, client_xpath.success_popup);
			if (client_xpath.success_popup.getText().equalsIgnoreCase("Professional unsuspended successfully!")) {
				test.log(Status.PASS, client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			} else {
				test.log(Status.FAIL,
						"Message should be 'Professional unsuspended successfully!'	 but it displays - "
								+ client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.INFO, e.toString(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
		}

	}

	// Delete Professional test script
	public void Delete_client(ExtentTest test, WebDriver driver) throws IOException, AWTException {

		Client_xpath client_xpath = new Client_xpath(driver);

		try {

			fun.Click(driver, client_xpath.delete_first_client);
			fun.Click(driver, client_xpath.confirm_alert_button);
			fun.explicit_Wait(driver, client_xpath.success_popup);
			if (client_xpath.success_popup.getText().equalsIgnoreCase("Professional deleted successfully!")) {
				test.log(Status.PASS, client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			} else {
				test.log(Status.FAIL,
						"Message should be 'Professional deleted successfully!'	 but it displays - "
								+ client_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				fun.explicit_Wait_invisible(driver, client_xpath.success_popup);
				test.log(Status.INFO, "Success pop-up closed.",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.INFO, e.toString(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
		}

	}

}
