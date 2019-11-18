package net.talaatharb.selenium;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Selenium Test application
 * 
 * @author mharb
 *
 */
public class SeleniumApplication {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(SeleniumApplication.class.getName());

	/**
	 * Maximum wait time
	 */
	private static final long MAX_WAIT_TIME = 3;

	/**
	 * Site URL to enter
	 */
	private static final String SITE_URL = "https://www.facebook.com";

	/**
	 * How long to wait before application termination
	 */
	private static final long TERMINATION_DELAY = 6000;

	/**
	 * Main application entry point
	 * 
	 * @param args The arguments to the application
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {

		// Configure logger
		LOGGER.setLevel(Level.INFO);
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");

		// Creating web driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		final WebDriver webDriver = new ChromeDriver();
		LOGGER.info("Web driver created");

		// Setting implicit wait instead of sleep
		webDriver.manage().timeouts().implicitlyWait(MAX_WAIT_TIME, TimeUnit.SECONDS);
		LOGGER.info("Web driver implicit wait set to " + MAX_WAIT_TIME + "s");

		// Opening web site
		webDriver.get(SITE_URL);
		LOGGER.info("Site: \"" + SITE_URL + "\" is open");

		webDriver.manage().window().maximize();
		LOGGER.info("Window maximized");

		// Filling form details
		// First name
		final WebElement firstNameElement = webDriver.findElement(By.id("u_0_f"));
		firstNameElement.sendKeys("Test");
		LOGGER.info("First name entered");

		// Last name
		final WebElement lastNameElement = webDriver.findElement(By.id("u_0_h"));
		lastNameElement.sendKeys("Test");
		LOGGER.info("Last name entered");

		// Email
		final WebElement emailElement = webDriver.findElement(By.id("u_0_k"));
		emailElement.sendKeys("Test@test.com");
		LOGGER.info("Email entered");

		// Repeated Email
		final WebElement repeatedEmailElement = webDriver.findElement(By.id("u_0_n"));
		repeatedEmailElement.sendKeys("Test@test.com");
		LOGGER.info("Repeated email entered");

		// Password
		final WebElement passwordElement = webDriver.findElement(By.id("u_0_p"));
		passwordElement.sendKeys("Test");
		LOGGER.info("Password entered");

		// Month
		final WebElement monthElement = webDriver.findElement(By.xpath("//*[@id=\"month\"]"));
		monthElement.click();
		monthElement.sendKeys("jjj");
		LOGGER.info("Month chosen");
		monthElement.click();

		// Day
		final WebElement dayElement = webDriver.findElement(By.xpath("//*[@id=\"day\"]"));
		dayElement.click();
		dayElement.sendKeys("7");
		LOGGER.info("Day chosen");
		dayElement.click();

		// Year
		final WebElement yearElement = webDriver.findElement(By.xpath("//*[@id=\"year\"]"));
		yearElement.click();
		yearElement.sendKeys("2");
		yearElement.click();
		yearElement.click();
		yearElement.sendKeys("111111111111");
		LOGGER.info("Year chosen");
		yearElement.click();

		// Gender = male
		WebElement genderMaleElement;
		try {
			genderMaleElement = webDriver.findElement(By.xpath("//*[@id=\"u_0_a\"]"));
		} catch (final NoSuchElementException e) {
			LOGGER.warning("Failed to get gender by using alphabetic ID");
			genderMaleElement = webDriver.findElement(By.xpath("//*[@id=\"u_0_7\"]"));
			LOGGER.info("Trying numeric ID works");
		}
		genderMaleElement.click();
		LOGGER.info("Gender chosen");

		// Sign up button
		final WebElement signUpElement = webDriver.findElement(By.id("u_0_w"));
		signUpElement.click();
		LOGGER.info("Sign up clicked");

		try {
			Thread.sleep(TERMINATION_DELAY);
		} catch (InterruptedException e) {
			LOGGER.warning(e.getMessage());
			Thread.currentThread().interrupt();
		}

		// Quitting
		webDriver.quit();
		LOGGER.info("Web driver terminated");

		System.exit(0);
	}
}
