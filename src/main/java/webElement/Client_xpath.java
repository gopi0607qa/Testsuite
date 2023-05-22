package webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Client_xpath extends Testbase {

	public Client_xpath(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),' Manage Professionals')]")
	public WebElement manage_client_menu;

	@FindBy(xpath = "//button[contains(text(),'+ Add Professional')]")
	public WebElement add_client_button;

	@FindBy(xpath = "//select[@id='formSelect']")
	public WebElement select_shop;

	@FindBy(xpath = "//select[@id='formprofessionSelect']")
	public WebElement select_profession;

	@FindBy(id = "formGridFirstName")
	public WebElement client_first_name;

	@FindBy(id = "formGridLastName")
	public WebElement client_last_name;

	@FindBy(id = "formGridEmail")
	public WebElement client_email;

	@FindBy(id = "formGridPhone")
	public WebElement client_phone;

	@FindBy(id = "formGridAddress1")
	public WebElement client_address_1;

	@FindBy(id = "formGridAddress2")
	public WebElement client_address_2;

	@FindBy(id = "formGridCity")
	public WebElement client_city;

	@FindBy(xpath = "//*[@id = 'formGridState']")
	public WebElement select_state;

	@FindBy(xpath = "//*[@id = 'formGridCountry']")
	public WebElement select_county;

	@FindBy(id = "formGridZip")
	public WebElement client_zipcode;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement client_form_submit;

	@FindBy(xpath = "//div[@class='swal2-popup swal2-modal swal2-icon-success swal2-show']")
	public WebElement success_popup;

	@FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[1]/td[2]")
	public WebElement first_client_list;

	@FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[1]/td[8]/div/div[1]/img")
	public WebElement delete_first_client;

	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled swal2-default-outline']")
	public WebElement confirm_alert_button;

	@FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[1]/td[8]/div/div[2]/img")
	public WebElement suspend_first_button;
}
