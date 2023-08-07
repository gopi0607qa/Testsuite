package webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Professional_xpath extends Testbase {

	public Professional_xpath(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'Settings')]")
	public WebElement settings_page;

	@FindBy(xpath = "//label[normalize-space()='Select a file to upload']")
	public WebElement profile_image_select_button;

	@FindBy(xpath = "//img[@class='ReactCrop__image']")
	public WebElement image_crop;

	@FindBy(xpath = "//button[normalize-space()='Crop']")
	public WebElement crop_button;

	@FindBy(xpath = "//div[@class='cropingUpload hstack gap-3']//div//button[@type='button'][normalize-space()='UPLOAD']")
	public WebElement profile_image_upload_button;

	@FindBy(xpath = "//div[@class='swal2-popup swal2-modal swal2-icon-success swal2-show']")
	public WebElement success_popup;

	@FindBy(xpath = "//img[@alt='uploaded']")
	public WebElement profile_image;

	@FindBy(xpath = "//div[@class='hstack gap-3']//div//div[@class='profile-details']//img")
	public WebElement logo_image;

	@FindBy(xpath = "//button[normalize-space()='Select a file to upload']")
	public WebElement logo_image_select_button;

	@FindBy(xpath = "//div[@class='upload__image-wrapper']//div[@class='hstack gap-3']//div//button[@type='button'][normalize-space()='UPLOAD']")
	public WebElement logo_image_upload_button;

}
