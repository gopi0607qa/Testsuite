package webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Login_xpath extends Testbase {

	public Login_xpath(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "formBasicEmail")
	public WebElement email_field;

	@FindBy(id = "formBasicPassword")
	public WebElement password_field;

	@FindBy(xpath = "//div[@class='mb-4']/p")
	public WebElement error_mail;

	@FindBy(xpath = "//div[@class='mb-4 ']/p")
	public WebElement error_password;

	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	public WebElement Login_button;

	@FindBy(xpath = "//div[@id='swal2-html-container']")
	public WebElement alert_msg;

}
