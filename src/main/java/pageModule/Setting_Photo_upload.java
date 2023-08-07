package pageModule;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import util.Currentdate;
import util.Email_custom;
import webElement.Professional_xpath;

public class Setting_Photo_upload {

	public BasicFunction fun = new BasicFunction();

	public void Profile_upload(ExtentTest test, WebDriver driver, String testname, String browser)
			throws IOException, InterruptedException, AWTException {

		Professional_xpath prof_xpath = new Professional_xpath(driver);
		try {
			fun.Click(driver, prof_xpath.settings_page);

			// copying File path to Clipboard
			StringSelection str = new StringSelection(
					"C:\\Users\\Gopinath\\Downloads\\Selenium images\\pexels-michelle-le.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

			fun.explicit_Wait(driver, prof_xpath.profile_image_select_button);
			fun.Click(driver, prof_xpath.profile_image_select_button);

//			fun.fluentWait(driver, prof_xpath.profile_image_upload_button);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(6000);
			fun.Photoupload();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			fun.Click(driver, prof_xpath.image_crop);
			fun.image_crop(driver, prof_xpath.image_crop);
			fun.Click(driver, prof_xpath.crop_button);
			fun.Click(driver, prof_xpath.profile_image_upload_button);
			if (prof_xpath.success_popup.getText().equalsIgnoreCase("Image Updated Successfully") == true) {

				System.out.println("Profile image upload test passed. The Pop-up message is "
						+ prof_xpath.success_popup.getText());
				test.log(Status.PASS,
						"Profile image upload test passed. The Pop-up message is " + prof_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				String e_messagepass = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On " + '\n' + '\n'
						+ Currentdate.Systemdate() + " Profile photo upload test is PASSED..!";
				String teststatus = "Profile photo upload test passed.";
				Email_custom.emailSendpass(testname, teststatus, e_messagepass);

			} else if (prof_xpath.success_popup.getText().equalsIgnoreCase("Image Updated Successfully") == false) {

				System.out.println(
						"Profile image upload test passed. But the Pop-up message is different. The Pop-up message is "
								+ prof_xpath.success_popup.getText());

				test.log(Status.FAIL,
						"Profile image upload test Failed. The Pop-up message is " + prof_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				String e_messagefail = "On " + Currentdate.Systemdate() + " Profile photo upload test is failed. "
						+ " Message displayed is " + prof_xpath.success_popup.getText() + '\n' + browser + '\n' + '\n';
				String teststatus = "{Profile upload test failed.";
				Email_custom.emailSendfail(testname, teststatus, e_messagefail);

			}
		} catch (Exception e) {

			System.out.println("Profile photo upload test failed");
			String e_messagefail = "On " + Currentdate.Systemdate() + ". Profile photo upload test failed." + '\n'
					+ "Tested browser: " + '\n' + browser + '\n' + '\n' + "Exception message: " + '\n'
					+ ExceptionUtils.getStackTrace(e);
			String teststatus = "Test failed";
			test.log(Status.FAIL,
					"On " + Currentdate.Systemdate() + " Profile photo upload Test Failed. The opened URL is : "
							+ driver.getCurrentUrl() + "Exception:  " + e_messagefail,
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			Email_custom.emailSendfail(testname, teststatus, e_messagefail);

		}

	}

	public void Logo_upload(ExtentTest test, WebDriver driver, String testname, String browser)
			throws IOException, InterruptedException, AWTException {

		Professional_xpath prof_xpath = new Professional_xpath(driver);
		try {
			fun.Click(driver, prof_xpath.settings_page);

			// copying File path to Clipboard
			StringSelection str = new StringSelection(
					"C:\\Users\\Gopinath\\Downloads\\Selenium images\\0266554465-ImResizer.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

			fun.explicit_Wait(driver, prof_xpath.logo_image_select_button);
			fun.Click(driver, prof_xpath.logo_image_select_button);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			Thread.sleep(10000);
			fun.Photoupload();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			fun.Click(driver, prof_xpath.logo_image_upload_button);
			if (prof_xpath.success_popup.getText().equalsIgnoreCase("Logo Updated Successfully") == true) {

				System.out.println(
						"Logo image upload test passed. The Pop-up message is " + prof_xpath.success_popup.getText());
				test.log(Status.PASS,
						"Logo image upload test passed. The Pop-up message is " + prof_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				String e_messagepass = "Browser details:" + '\n' + '\n' + browser + '\n' + '\n' + "On " + '\n' + '\n'
						+ Currentdate.Systemdate() + " Logo photo upload test is PASSED..!";
				String teststatus = "Logo photo upload test passed.";
				Email_custom.emailSendpass(testname, teststatus, e_messagepass);

			} else if (prof_xpath.success_popup.getText().equalsIgnoreCase("Logo Updated Successfully") == false) {

				System.out.println(
						"Logo image upload test passed. But the Pop-up message is different. The Pop-up message is "
								+ prof_xpath.success_popup.getText());

				test.log(Status.FAIL,
						"Logo image upload test Failed. The Pop-up message is " + prof_xpath.success_popup.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
				String e_messagefail = "On " + Currentdate.Systemdate() + " Logo photo upload test is failed. "
						+ " Message displayed is " + prof_xpath.success_popup.getText() + '\n' + browser + '\n' + '\n';
				String teststatus = "{Logo upload test failed.";
				Email_custom.emailSendfail(testname, teststatus, e_messagefail);

			}
		} catch (Exception e) {

			System.out.println("Logo photo upload test failed");
			String e_messagefail = "On " + Currentdate.Systemdate() + ". Logo photo upload test failed." + '\n'
					+ "Tested browser: " + '\n' + browser + '\n' + '\n' + "Exception message: " + '\n'
					+ ExceptionUtils.getStackTrace(e);
			String teststatus = "Test failed";
			test.log(Status.FAIL,
					"On " + Currentdate.Systemdate() + " Logo photo upload Test Failed. The opened URL is : "
							+ driver.getCurrentUrl() + "Exception:  " + e_messagefail,
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshotfullpage(driver)).build());
			Email_custom.emailSendfail(testname, teststatus, e_messagefail);

		}

	}
}