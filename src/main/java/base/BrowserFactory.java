package base;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

	public WebDriver createbrowserInstance(String browsername) {

		WebDriver driver = null;

		if (browsername.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--remote-allow-origins=*");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(options);
//			DevTools devtools = ((ChromeDriver) driver).maybeGetDevTools().get();
//			devtools.createSession();
//			devtools.send(Emulation.setTimezoneOverride("US/Pacific"));

		} else if (browsername.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--private");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.setPageLoadTimeout(Duration.ofSeconds(10));
			driver = new FirefoxDriver(options);
//			DevTools devtools = ((FirefoxDriver) driver).getDevTools();
//			devtools.createSession();
//			devtools.send(Emulation.setTimezoneOverride("US/Pacific"));

		} else if (browsername.equalsIgnoreCase("Edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("InPrivate");
			options.addArguments("--remote-allow-origins=*");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new EdgeDriver(options);
//			DevTools devtools = ((EdgeDriver) driver).maybeGetDevTools().get();
//			devtools.createSession();
//			devtools.send(Emulation.setTimezoneOverride("US/Pacific"));

		}

		return driver;

	}

}
