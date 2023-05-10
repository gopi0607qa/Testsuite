package webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Profession_xpath extends Testbase {

	public Profession_xpath(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'Manage Professions')]")
	public WebElement manage_profession_menu;

	@FindBy(xpath = "//button[contains(text(),'+ Add Profession')]")
	public WebElement add_profession_button;

	@FindBy(xpath = "//input[@id='formBasicEmail']")
	public WebElement profession_input;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement add_button;

	@FindBy(xpath = "//div[@class='swal2-popup swal2-modal swal2-icon-success swal2-show']")
	public WebElement success_popup;

	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled swal2-default-outline']")
	public WebElement confirm_alert_button;

	@FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr/td[contains(text(),'Edit Selenium test')]/following-sibling::td/div/div[1]")
	public WebElement delete_button;

	@FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr/td[contains(text(),'Selenium test')]/following-sibling::td/div/div[2]")
	public WebElement edit_button;

}
