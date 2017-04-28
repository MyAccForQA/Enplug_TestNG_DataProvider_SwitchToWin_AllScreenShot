package mywebdriver;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
// import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWebDriver {

	private static long TCCount = 0;
	
	private WebDriver driver = null;

	private enum EnumDriverType {
		ff, ch, ie, hu;
	}

	private String driverTypeRead = null; // "ff"; // ff, ch, ie, hu
	EnumDriverType enumDriverType = null; // EnumDriverType.valueOf(driverTypeRead);

	private final static String folder = "screenshot//";

	private WebDriverWait wait;
	private static final long VISIBILITY_TIMEOUT = 30;
	private static final int highlightWait = 600; // milisec

	private String url = null;

	// constustor START!!!!!!!!!!!!!!!!!!!!!!!
	// constustor START!!!!!!!!!!!!!!!!!!!!!!!
	// constustor START!!!!!!!!!!!!!!!!!!!!!!!
	public MyWebDriver() {
		// this.url = url;

		// when start - first run
		if (driver == null) {

			// read driverTypeRead from Property
			// String driverType =
			// System.getProperties().getProperty("driverType").toLowerCase();
			driverTypeRead = "ff";
			enumDriverType = EnumDriverType.valueOf(driverTypeRead);

			// open browser
			driver = OpenBrowser(enumDriverType);

			wait = new WebDriverWait(driver, VISIBILITY_TIMEOUT);
			// driver.manage().window().maximize();
		} // if (driver == null) {
	}

	/*
	 * public WSWebDriver(final String url) { this();
	 * 
	 * openHomePage(url.toString()); }
	 */
	// constustor END!!!!!!!!!!!!!!!!!!!!!!!
	// constustor END!!!!!!!!!!!!!!!!!!!!!!!
	// constustor END!!!!!!!!!!!!!!!!!!!!!!!

	////////////////////////////// private START//////////////////////////////
	////////////////////////////// private START//////////////////////////////
	////////////////////////////// private START//////////////////////////////
	private WebDriver OpenBrowser(EnumDriverType driverType) {
		WebDriver dr;
		switch (driverType) {
		case ff: // "ff"
			dr = new FirefoxDriver();
			break;
		case ch: // "ch"
			// dr = new ChromeDriver();
			dr = new FirefoxDriver();
			break;
		case ie: // "ie"
			// dr = new InternetExplorerDriver();
			dr = new FirefoxDriver();
			break;
		case hu: // "hu"
			// dr = new HtmlUnitDriver();
			// ((HtmlUnitDriver) dr).setJavascriptEnabled(true);
			dr = new FirefoxDriver();
			break;
		default:
			dr = new FirefoxDriver();
			break;
		}
		return dr;
	}
	////////////////////////////// private END//////////////////////////////
	////////////////////////////// private END//////////////////////////////
	////////////////////////////// private END//////////////////////////////

	////////////////////////////// public START//////////////////////////////
	////////////////////////////// public START//////////////////////////////
	////////////////////////////// public START//////////////////////////////
	public WebDriverWait getWait() {
		return wait;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public String getURL() {
		return url;
	}

	public void back() {
		driver.navigate().back();
	}

	public static long getTCCountStart() {
		return ++TCCount;
	}

	public static long getTCCountFinish() {
		return TCCount;
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}

	public void openHomePage() {
		openHomePage(url);
	}

	public void openHomePage(final String url) {
		// driver.navigate().to(url);
		driver.get(url.toString());
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void takesScreenshot(String fname) {
		// driver = new Augmenter().augment(driver);
		final WebDriver augmentedDriver = new Augmenter().augment(driver);
		File srcFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(folder + fname + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Highlight elements on the page with no time */
	public WebElement highlight(final WebElement element) {
		highlight(element, highlightWait);
		return element;
	}

	/* Highlight elements on the page with time */
	public WebElement highlight(final WebElement element, int time) {
		final String originalBackgroundColor = element.getCssValue("backgroundColor");
		final JavascriptExecutor myJS = ((JavascriptExecutor) driver); // java
																		// script
		myJS.executeScript("arguments[0].style.backgroundColor = 'rgb(0,200,0)'", element);

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
		myJS.executeScript("arguments[0].style.backgroundColor = '" + originalBackgroundColor + "'", element);
		return element;
	}

	public void quit() {
		driver.quit();
	}
	
	public void close() {
		driver.close();
	}
	////////////////////////////// public EDN//////////////////////////////
	////////////////////////////// public EDN//////////////////////////////
	////////////////////////////// public EDN//////////////////////////////
}