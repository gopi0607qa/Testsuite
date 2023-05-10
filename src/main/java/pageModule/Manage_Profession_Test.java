package pageModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import webElement.Profession_xpath;

public class Manage_Profession_Test extends Testbase {

	public BasicFunction fun = new BasicFunction();

	public void Add_Profession(ExtentTest test, WebDriver driver) throws IOException {

		Profession_xpath pro_xpath = new Profession_xpath(driver);

		try {
			fun.Click(driver, pro_xpath.manage_profession_menu);
			test.log(Status.INFO, "Manage Profession menu is clicked.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Click(driver, pro_xpath.add_profession_button);
			test.log(Status.INFO, "Add Profession button is clicked.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Sendkeys(driver, pro_xpath.profession_input, "Selenium test");
			test.log(Status.INFO, "Selenium test is entered in Profession input field ",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Click(driver, pro_xpath.add_button);
			test.log(Status.INFO, "Add button in Add Profession pop-up is clicked.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.explicit_Wait(driver, pro_xpath.success_popup);
			if (pro_xpath.success_popup.getText().equalsIgnoreCase("Profession added successfully")) {
				test.log(Status.PASS,
						"Success pop-up is displayed and the message is " + pro_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

				fun.explicit_Wait_invisible(driver, pro_xpath.success_popup);
				test.log(Status.INFO, "Success pop-up is closed",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			} else {
				test.log(Status.FAIL,
						"Expected text is Profession added successfully actual text is "
								+ pro_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, "Add Profession failed. Exception message is " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			e.printStackTrace();

		}

	}

	public void Edit_Profession(ExtentTest test, WebDriver driver) throws IOException {
		Profession_xpath pro_xpath = new Profession_xpath(driver);

		try {
			fun.Click(driver, pro_xpath.manage_profession_menu);
			test.log(Status.INFO, "Manage Profession menu is clicked.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Click(driver, pro_xpath.edit_button);
			test.log(Status.INFO, "Edit Profession icon is clicked.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Sendkeys(driver, pro_xpath.profession_input, "Edit Selenium test");
			test.log(Status.INFO, "Text is entered in text input field",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Click(driver, pro_xpath.add_button);
			test.log(Status.INFO, "Update button is clicked.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			fun.explicit_Wait(driver, pro_xpath.success_popup);

			if (pro_xpath.success_popup.getText().equalsIgnoreCase("Profession updated successfully")) {

				test.log(Status.PASS,
						"Success pop-up is displayed and the message is " + pro_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

				fun.explicit_Wait_invisible(driver, pro_xpath.success_popup);
				test.log(Status.INFO, "Success pop-up is closed",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			} else {
				test.log(Status.FAIL,
						"Expected message is Profession updated successfully, actual message is "
								+ pro_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			e.printStackTrace();
		}

	}

	public void Delete_Profession(ExtentTest test, WebDriver driver) throws IOException {

		Profession_xpath pro_xpath = new Profession_xpath(driver);

		try {
			fun.Click(driver, pro_xpath.manage_profession_menu);
			test.log(Status.INFO, "Manage Profession menu is clicked.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Click(driver, pro_xpath.delete_button);
			test.log(Status.INFO, "Delete button is clicked.",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			fun.Click(driver, pro_xpath.confirm_alert_button);
			test.log(Status.INFO, "Success pop-up is displayed",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			fun.explicit_Wait(driver, pro_xpath.success_popup);

			if (pro_xpath.success_popup.getText().equalsIgnoreCase("Profession deleted successfully!")) {
				test.log(Status.PASS,
						"Success pop-up is displayed and the message is " + pro_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

				fun.explicit_Wait_invisible(driver, pro_xpath.success_popup);
				test.log(Status.INFO, "Success pop-up is closed",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());

			} else {
				test.log(Status.FAIL,
						"Expected message is 'Profession deleted successfully!' but the message is '"
								+ pro_xpath.success_popup.getText() + "'",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			e.printStackTrace();
		}

	}

}
