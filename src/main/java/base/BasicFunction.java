package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BasicFunction extends Testbase {
	WebDriver driver = DriverFactory.getInstance().getDriver();

	// Method to wait web driver till element is visible
	public void explicit_Wait(WebDriver driver, WebElement xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(xpath));

	}

	// Method to wait web driver till element is invisible
	public void explicit_Wait_invisible(WebDriver driver, WebElement xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(xpath));

	}

	// Method to wait web driver till element is clickable.
	public void explicit_Wait_Click(WebDriver driver, WebElement xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(xpath));

	}

	// Method to wait web driver till element is visible of all element in the list.
	public void explicit_Wait_List(WebDriver driver, List<WebElement> product_List_Category) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(product_List_Category));

	}

	// Method to wait web driver for a element ignoring No Such Element exception.
	public WebElement fluentWait(WebDriver driver, final WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		WebElement elementWaitedFor = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return element;
			}
		});
		return elementWaitedFor;
	}

	// Method to click on visible element.
	public void Click(WebDriver driver, WebElement xpath) {
		try {
			explicit_Wait_Click(driver, xpath);
			xpath.click();
		} catch (Exception e) {
			explicit_Wait_Click(driver, xpath);
			xpath.click();
			e.printStackTrace();
		}
	}

	// Method to Send String data to text input field.
	public void Sendkeys(WebDriver driver, WebElement xpath, String value) {
		try {
			fluentWait(driver, xpath);
			Scroll(driver, xpath);
			xpath.click();
			xpath.clear();
			xpath.sendKeys(value);
		} catch (Exception e) {
			fluentWait(driver, xpath);
			xpath.click();
			xpath.clear();
			xpath.sendKeys(value);
			e.printStackTrace();
		}
	}

	// Method to Send String Buffer data to text input field.
	public void Sendkeys(WebDriver driver, WebElement xpath, StringBuffer value) {
		try {
			fluentWait(driver, xpath);
			Scroll(driver, xpath);
			xpath.click();
			xpath.sendKeys(value);
		} catch (Exception e) {
			fluentWait(driver, xpath);
			xpath.click();
			xpath.sendKeys(value);
			e.printStackTrace();
		}
	}

	// Method to scroll to view the web element.
	public void Scroll(WebDriver driver, WebElement xpath) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			explicit_Wait(driver, xpath);
			js.executeScript("arguments[0].scrollIntoView();", xpath);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// Method to select date given is "11".
	public void DateSelect() throws AWTException {
		for (int i = 11; i > 1; i--) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
	}

	// Robot class method for Photoupload
	public void Photoupload() throws AWTException {

		// creating object of Robot class
		Robot rb = new Robot();

		try {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);

			// press Contol+V for pasting
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_A);

			// release Contol+V for pasting
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_A);

			rb.keyPress(KeyEvent.VK_BACK_SPACE);
			rb.keyRelease(KeyEvent.VK_BACK_SPACE);

			// press Contol+V for pasting
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			// release Contol+V for pasting
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.delay(4000);

			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);

			// for pressing and releasing Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);

			// press Contol+V for pasting
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_A);

			// release Contol+V for pasting
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_A);

			rb.keyPress(KeyEvent.VK_BACK_SPACE);
			rb.keyRelease(KeyEvent.VK_BACK_SPACE);

			// press Contol+V for pasting
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			// release Contol+V for pasting
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.delay(4000);

			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);

			// for pressing and releasing Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			e.printStackTrace();
		}

	}

	public void image_crop(WebDriver driver, WebElement xpath) {

		new Actions(driver).clickAndHold(xpath).moveByOffset(20, 20).release(xpath).build().perform();

	}

	// Method to Take screenshot
	public String capturescreenshot(WebDriver driver) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("d-M-yyyy hh:mm:ss");
		Date date = new Date();
		File Dest = new File(System.getProperty("user.dir") + "src/test/resources/output/Screenshot/"
				+ dateFormat.format(date) + "Screenshot" + System.currentTimeMillis() + ".png");

		Screenshot screenshot = new AShot().takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "png", Dest);
		String errflpath = Dest.getAbsolutePath();

		return errflpath;

	}

	// Method to Take the screenshot Full Page

	public String capturescreenshotfullpage(WebDriver driver) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy H-m-s-S");
		Date date = new Date();
		File Dest = new File(System.getProperty("user.dir") + "/src/test/resources/output/Screenshot/"
				+ dateFormat.format(date) + "Screenshot" + System.currentTimeMillis() + ".png");

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "png", Dest);
		String errflpath = Dest.getAbsolutePath();

		return errflpath;

	}

	// Method to scroll to particular web element.
	public void Scroll(WebDriver driver, List<WebElement> xpath) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			explicit_Wait_List(driver, xpath);
			js.executeScript("arguments[0].scrollIntoView();", xpath);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
